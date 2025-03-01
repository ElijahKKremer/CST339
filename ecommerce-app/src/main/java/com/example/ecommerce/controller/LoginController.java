package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {



    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Returns the login page
    }

    @PostMapping("/login")
    public String authenticateUser(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        // Debug log: Check if username is received correctly
        System.out.println("Attempting to log in user: " + username);

        // Fetch user from the repository by username
        User user = userRepository.findByUsername(username);
        
        if (user != null && user.getPassword().equals(password)) {
            // Store user information in session
            session.setAttribute("username", username);
         // Redirect to the product page
            return "redirect:/products";  // Ensure this redirection works
            
            // Add username to model for view if needed
            //model.addAttribute("username", username);
            	
        }
        
        // If login failed, show error message
        model.addAttribute("error", "Invalid credentials.");
        return "login"; // Return to the login page
    }
}
