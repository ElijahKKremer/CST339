package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service  // Spring will automatically manage this as a Spring Bean
public class RegistrationService {

    // In-memory list of registered users
    private List<User> userList = new ArrayList<>();

    // Method to register a new user
    public void registerUser(User user) {
        // Add the user to the in-memory list (not persisting in DB)
        userList.add(user);
        System.out.println("User registered: " + user.getUsername());
    }

    // Optionally, method to check if a user exists (for login functionality)
    public boolean isUserExists(String username) {
        return userList.stream().anyMatch(user -> user.getUsername().equals(username));
    }
    
 // Method to fetch all users (for login comparison)
    public List<User> getAllUsers() {
        return userList;
    }
}
