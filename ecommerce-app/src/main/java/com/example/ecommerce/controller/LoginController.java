package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserRepository userRepository; // Use repository instead of service

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String loginUser(User user, Model model) {
        // Use the repository to find the user by username
        User registeredUser = userRepository.findByUsername(user.getUsername());
        
        // If the user exists, check if the password matches
        if (registeredUser != null && registeredUser.getPassword().equals(user.getPassword())) {
            // Login successful
            return "home";
        }
        
        // If authentication fails, show an error
        model.addAttribute("error", "Invalid username or password.");
        return "login";
    }
}

