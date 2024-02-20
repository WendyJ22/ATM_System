package com.bjpowernode.util;

import java.sql.*;

public class DBUtils {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sh2302?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    public static void close(Statement statement , Connection connection) {
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet resultSet , Statement statement , Connection connection) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(statement, connection);
    }
}
