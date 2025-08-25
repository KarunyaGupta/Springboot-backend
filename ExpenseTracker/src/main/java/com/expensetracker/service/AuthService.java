package com.expensetracker.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.mindrot.jbcrypt.BCrypt;

import com.expensetracker.model.User;

public class AuthService {
    private final Map<String, User> usernameToUser = new ConcurrentHashMap<>();

    public synchronized boolean signUp(String username, String password) {
        if (usernameToUser.containsKey(username)) {
            return false;
        }
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        usernameToUser.put(username, new User(username, passwordHash));
        return true;
    }

    public User login(String username, String password) {
        User user = usernameToUser.get(username);
        if (user == null) {
            return null;
        }
        boolean valid = BCrypt.checkpw(password, user.getPasswordHash());
        return valid ? user : null;
    }
}


