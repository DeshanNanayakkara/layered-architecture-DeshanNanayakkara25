package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.CustomDto;

import java.sql.SQLException;
import java.util.List;

public interface QueryDao {
    //void customerOrderDetails(CustomDto customDto) throws SQLException, ClassNotFoundException;

    List <CustomDto> customerOrderDetails() throws SQLException, ClassNotFoundException;
}
