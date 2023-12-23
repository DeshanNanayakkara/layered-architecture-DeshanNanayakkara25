package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.SqlUtil;
import com.example.layeredarchitecture.dao.custom.OrderDetailDao;

import java.math.BigDecimal;
import java.sql.SQLException;


public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public boolean saveOrderDetail(String orderId, String itemCode, BigDecimal unitPrice, int qty) throws SQLException, ClassNotFoundException {

        return SqlUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", orderId, itemCode, unitPrice, qty);

    }
}
