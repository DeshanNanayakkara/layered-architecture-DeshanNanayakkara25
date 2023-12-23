package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public String genarateId() throws SQLException, ClassNotFoundException;
    public void delete(String id) throws SQLException, ClassNotFoundException;
}
