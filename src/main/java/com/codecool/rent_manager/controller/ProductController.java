package com.codecool.rent_manager.controller;

import com.codecool.rent_manager.model.ProcessedProduct;
import com.codecool.rent_manager.model.Product;
import com.codecool.rent_manager.model.ProductRepository;
import com.codecool.rent_manager.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://localhost:8888"})
@RestController
@RequestMapping("/product")
public class ProductController { // Controller for products table

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductManager productManager;

    @GetMapping("/all")
    public List<ProcessedProduct> getAllProducts() {
        List<Product> dbResponse = productRepository.getAll();
        return productManager.connectProductIdWithName(dbResponse);
    }

    @PutMapping("/modify")
    public Product modifyProduct(@RequestBody Product product) {
        productManager.updateProduct(product);
        return product;
    }
}
