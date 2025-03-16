package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    private List<Product> productList = new ArrayList<>();

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
 // Show the form to create a new product
    @GetMapping("/products/create")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";  // This will show the form to create a new product
    }

    // Handle the form submission and add the new product to the in-memory list
    @PostMapping("/products/create")
    public String createProduct(@ModelAttribute Product product, Model model) {
    	System.out.println("Creating product: " + product.getName());
    	// Add the new product to the in-memory list
        productRepository.save(product); ///////////////////////////////////save vs productList.get

        // Redirect back to the products page to see the list
        return "redirect:/products";
    }
}

