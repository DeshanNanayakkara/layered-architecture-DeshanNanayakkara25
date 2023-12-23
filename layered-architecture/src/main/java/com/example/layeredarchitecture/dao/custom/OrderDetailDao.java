package com.example.layeredarchitecture.dao.custom;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface OrderDetailDao {
    public boolean saveOrderDetail(String orderId, String itemCode, BigDecimal unitPrice, int qty) throws SQLException, ClassNotFoundException;
}
