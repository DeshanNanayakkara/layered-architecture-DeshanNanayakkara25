package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.SqlUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("Insert into item values (?,?,?,?)", dto.getCode(),dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice());
    }
    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("UPDATE Item SET description=?, qtyOnHand=?, unitprice=? WHERE code=?", dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice(),dto.getCode());
    }
    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.execute("SELECT code FROM Item WHERE code=?", code);
        return resultSet.next();
    }
    @Override
    public void delete(String code) throws SQLException, ClassNotFoundException {
        SqlUtil.execute("DELETE FROM Item WHERE code=?", code);
    }
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> allItem = new ArrayList<>();

        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getInt("qtyOnHand"),
                    rst.getBigDecimal("unitPrice"));
            allItem.add(itemDTO);
        }
        return allItem;
    }
    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO find(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Item WHERE code=?", code);
        ItemDTO dto = null;
        while (rst.next()){
            dto = new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getBigDecimal(4)
            );
        }
        return dto;
    }

    public List<ItemDTO> loadAllIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Item");
        List <ItemDTO> dtoList = new ArrayList<>();
        while (rst.next()){
            dtoList.add(
                    new ItemDTO(
                            rst.getString(1)
                    )
            );
        }
        return dtoList;
    }
}