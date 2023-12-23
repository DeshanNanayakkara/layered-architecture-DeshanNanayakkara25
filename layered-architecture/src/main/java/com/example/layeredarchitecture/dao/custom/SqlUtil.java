package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlUtil {
    public static <T> T execute(String sql, Object... obj) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < obj.length; i++) {
            preparedStatement.setObject((i + 1), obj[i]);
        }
        if (sql.startsWith("SELECT")){
            return (T) preparedStatement.executeQuery();
        }else {
            return(T)(Boolean)(preparedStatement.executeUpdate()>0);
        }
    }
}
