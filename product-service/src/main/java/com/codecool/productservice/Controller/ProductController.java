package com.codecool.productservice.Controller;

import com.codecool.productservice.Model.Category;
import com.codecool.productservice.Model.Product;
import com.codecool.productservice.Repository.CategoryCaller;
import com.codecool.productservice.Repository.ProductRepository;
import com.codecool.productservice.Service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://localhost:8888"})
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductManager productManager;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryCaller categoryCaller;

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

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){

        Optional<Product> product = productRepository.findById(id);
        Category category = categoryCaller.getCategoryById("/" + product.get().getCategory_id());
        product.get().setCategory(category);
        return product;
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody Product product) {
        productManager.deleteProduct(product);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productManager.addProduct(product);
    }

}
