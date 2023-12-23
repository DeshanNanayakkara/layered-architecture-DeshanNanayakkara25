package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.SqlUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();*/

        ResultSet rst = SqlUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allCustomer = new ArrayList<>();

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            allCustomer.add(customerDTO);
        }
        return allCustomer;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", dto.getId(), dto.getName(), dto.getAddress());

    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
      SqlUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", dto.getName(),dto.getAddress(),dto.getId());
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.execute("SELECT id FROM Customer WHERE id=?", id);
        return resultSet.next();
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        SqlUtil.execute("delete from customer where id = ?", id);
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public List<CustomerDTO> loadAllIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Customer");
        List <CustomerDTO> dtoList = new ArrayList<>();
        while (rst.next()){
            dtoList.add(
                    new CustomerDTO(
                            rst.getString(1)
                    )
            );
        }
        return dtoList;
    }

    @Override
    public CustomerDTO find(String code) throws SQLException, ClassNotFoundException {
        return null;
    }
}
