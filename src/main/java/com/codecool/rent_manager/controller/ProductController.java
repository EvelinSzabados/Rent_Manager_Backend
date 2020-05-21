package com.codecool.rent_manager.controller;

import com.codecool.rent_manager.model.Product;
import com.codecool.rent_manager.model.Rent;
import com.codecool.rent_manager.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://localhost:8888"})
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductManager productManager;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productManager.productList();
    }

    @GetMapping("/available")
    public List<Product> getAllAvailableProducts(){
        return productManager.getAvailableProducts();
    }

    @PutMapping("/modify")
    public void modifyProduct(@RequestBody Product product) {
        productManager.updateProduct(product);
    }


    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody Product product) {
        productManager.deleteProduct(product);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productManager.addProduct(product);
    }

    @PostMapping("/setStatus/{id}")
    public void setProductStatusAvailable(@PathVariable Long id,@RequestBody Rent rent){productManager.setProductStatusAvailable(id,rent);}
}
