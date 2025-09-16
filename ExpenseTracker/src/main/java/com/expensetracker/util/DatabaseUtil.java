package com.expensetracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    // Database: projectdata, User: system, Password: 0660
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Connects to Oracle XE instance
    private static final String USER = "system"; // Oracle user
    private static final String PASSWORD = "0660"; // Oracle password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
