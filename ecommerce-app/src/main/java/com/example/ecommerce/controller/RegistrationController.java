package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    // Inject the RegistrationService via constructor-based DI
    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());  // Prepares the User object for binding form data
        return "register";  // Returns the registration view (register.html)
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        // Register the user by passing to the service
        registrationService.registerUser(user);

        // Add a success message and redirect to the login page
        model.addAttribute("message", "User registered successfully!");
        return "login";  // Redirect to the login page after registration
    }
}
