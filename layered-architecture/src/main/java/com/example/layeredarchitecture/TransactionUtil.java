package com.example.layeredarchitecture;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtil {
    static Connection connection;

    static {
        try {
            connection = DBConnection.getDbConnection().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TransactionUtil() throws SQLException, ClassNotFoundException {
    }

    public static void disableAutoCommit() throws SQLException {
        connection.setAutoCommit(false);
    }

    public static void enableAutoCommit() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
        //connection.close();
    }

    public static void rollBack() throws SQLException {
        connection.rollback();
        connection.setAutoCommit(true);
    }
}
