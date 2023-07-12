package com.example.productmvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String jdbcURL =
            "jdbc:mysql://localhost:3306/product_manage?useSSL=false";
    private static String username = "thanh";
    private static String password = "123456";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,username,password);
//            System.out.println("Success");
//            System.out.println("Error");
        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        getConnection();
    }
}
