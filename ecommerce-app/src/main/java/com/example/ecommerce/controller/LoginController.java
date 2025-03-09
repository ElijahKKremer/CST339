package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final RegistrationService registrationService;

    // Inject the RegistrationService via constructor-based DI
    @Autowired
    public LoginController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/login")
    public String loginUser(User user, Model model) {
        // Check if the user exists in the list (based on username and password)
        boolean userExists = registrationService.isUserExists(user.getUsername());
        
        // If the user exists, check if the password matches
        if (userExists) {
            for (User registeredUser : registrationService.getAllUsers()) {
                if (registeredUser.getUsername().equals(user.getUsername()) && 
                    registeredUser.getPassword().equals(user.getPassword())) {
                    // Login successful, redirect to the homepage or dashboard
                    return "home";
                }
            }
        }
        
        // If authentication fails, show an error
        model.addAttribute("error", "Invalid username or password.");
        return "login";
    }
}
