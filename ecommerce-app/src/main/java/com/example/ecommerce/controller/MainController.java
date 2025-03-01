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

   // @GetMapping("/register") 				IS THIS THE CONFLICT????????
   // public String registerPage() {
    //    return "register";
   // }
}
