package com.example.ecommerce.service;

import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Product;

@Service
public class ProductService {

    public boolean createProduct(Product product) {
        // Simulate product creation (without DB)
        System.out.println("Product Created: " + product.getName());
        return true;  // Simulate success
    }
}