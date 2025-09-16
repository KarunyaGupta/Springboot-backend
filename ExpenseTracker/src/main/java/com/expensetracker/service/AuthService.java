package com.expensetracker.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.expensetracker.model.User;
import com.expensetracker.util.DatabaseUtil;

public class AuthService {

    public synchronized boolean signUp(String username, String password) {
        // Check if user exists
        try (Connection conn = DatabaseUtil.getConnection()) {
            String checkSql = "SELECT username FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                return false; // User exists
            }
            String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
            String insertSql = "INSERT INTO users (username, password_hash) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, username);
            insertStmt.setString(2, passwordHash);
            insertStmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error during sign up: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public User login(String username, String password) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT username, password_hash FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String passwordHash = rs.getString("password_hash");
                boolean valid = BCrypt.checkpw(password, passwordHash);
                if (valid) {
                    return new User(username, passwordHash);
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}


