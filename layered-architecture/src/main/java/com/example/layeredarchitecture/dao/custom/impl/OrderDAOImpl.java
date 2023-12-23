package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.SqlUtil;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.time.LocalDate;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public OrderDTO generateNewOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        OrderDTO dto = null;
        while (rst.next()){
            dto = new OrderDTO(rst.getString(1));
        }
        return dto;
    }

    @Override
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException {

        return SqlUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)", orderId, Date.valueOf(orderDate), customerId);

    }
}
