package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Phone E-Commerce");
        return "index"; // Will render index.html in templates
    }
    
    @GetMapping("/about")
    public String aboutUs() {
        return "about";  // This will render the about.html page
    }
    
    @GetMapping("/error")
    public String errorPage() {
        return "error";  
    }

 
}
