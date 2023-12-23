package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO{
    CustomerDAO customerDAO = new CustomerDAOImpl();
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDAO.save(dto);
    }
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDAO.update(dto);
    }

    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    public String genarateId() throws SQLException, ClassNotFoundException {
        return customerDAO.genarateId();
    }

    public void delete(String id) throws SQLException, ClassNotFoundException {
        customerDAO.delete(id);
    }
}
