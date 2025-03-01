package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String showProducts(Model model) {
        // Debug log to confirm the page is being hit
        System.out.println("Loading products page...");

        // Fetch all products from the repository
        Iterable<Product> products = productRepository.findAll();
        
        // Add the products to the model so they can be displayed in the view
        model.addAttribute("products", products);
        
        return "products";  // This will return the products.html view
    }
}
