package com.example.ecommerce.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean authenticate(String username, String password) {
        return "user".equals(username) && "password".equals(password); // Hardcoded
    }
}