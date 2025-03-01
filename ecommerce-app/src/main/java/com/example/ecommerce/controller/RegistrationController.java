package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistrationController {

    // Handle GET request for the registration page
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // can add attributes to the model if needed, e.g., form objects
        model.addAttribute("user", new User());
        return "register";  // Returns the registration form view
    }

    // Handle POST request to process the registration form submission
    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") User user, BindingResult result) {
        // Logic for processing the registration
        // e.g., validate, save user to database, etc.
        if (result.hasErrors()) {
            return "register";  // Return to registration form if there are errors
        }

        // Assuming user is successfully saved
        return "registrationSuccess";  // A page indicating successful registration
    }
}
