package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.QueryDao;
import com.example.layeredarchitecture.dao.custom.SqlUtil;
import com.example.layeredarchitecture.model.CustomDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDaoImpl implements QueryDao {
    @Override
    public List <CustomDto> customerOrderDetails() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.execute("SELECT customer.*, orders.* FROM customer RIGHT JOIN orders ON customer.id = orders.customerID;");
        List <CustomDto> dtoList = new ArrayList<>();
        while (resultSet.next()){
            dtoList.add(new CustomDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5).toLocalDate()
            ));
        }
        return dtoList;
    }
}
