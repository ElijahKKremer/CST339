package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Show the list of all products
    @GetMapping("/products")
    public String showProducts(Model model) {
        Iterable<Product> products = productService.getAllProducts();  // Get all products from service
        model.addAttribute("products", products);
        return "products";  // This will return the products.html view
    }

    // Show the form to create a new product
    @GetMapping("/products/create")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";  // This will show the createProduct.html form
    }

    // Handle the form submission to create a new product
    @PostMapping("/products/create")
    public String createProduct(@ModelAttribute Product product) {
        productService.createProduct(product);  // Call service to create a product
        return "redirect:/products";  // Redirect to products list after creation
    }

    // Show the edit form for a product
    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);  // Get product by ID from service
        if (product != null) {
            model.addAttribute("product", product);
            return "editProduct";  // Render the editProduct.html page
        }
        return "redirect:/products";  // If product not found, redirect to the products list
    }

    // Handle the form submission to update a product
    @PostMapping("/products/edit")
    public String updateProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);  // Call service to update the product
        return "redirect:/products";  // Redirect to the products list after update
    }

    // Handle the deletion of a product
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);  // Call service to delete the product
        return "redirect:/products";  // Redirect to products list after deletion
    }
}

