package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create a new product
    public Product createProduct(Product product) {
        return productRepository.save(product);  // Save product to DB
    }

    // Update an existing product
    public Product updateProduct(Product product) {
        return productRepository.save(product);  // Update product in DB
    }

    // Delete a product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);  // Delete product by ID
    }

    // Get a product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);  // Fetch product from DB
    }

    // Get all products
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();  // Fetch all products
    }
}
