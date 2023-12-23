package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO {
    public OrderDTO generateNewOrderId() throws SQLException, ClassNotFoundException;
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;
}
