package com.example.layeredarchitecture.dao.Custom;

import com.example.layeredarchitecture.model.SearchDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO{
    public ArrayList<SearchDTO> getOrderDetail() throws SQLException, ClassNotFoundException;

}
