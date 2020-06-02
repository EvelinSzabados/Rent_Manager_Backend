package com.codecool.rent_manager.service;

import com.codecool.rent_manager.model.*;
import com.codecool.rent_manager.repository.ProductRepository;
import com.codecool.rent_manager.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductManager {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RentRepository rentRepository;

    public List<Product> productList() {
        return productRepository.findAll();
    }

    public void updateProduct(Product product) {
        Product productToEdit = productRepository.getOne(product.getId());
        productToEdit.setName(product.getName());
        productToEdit.setCategory(product.getCategory());
        productToEdit.setPrice(product.getPrice());
        productToEdit.setStatus(product.getStatus());
        productRepository.save(productToEdit);
    }

    public List<Product> getAvailableProducts() {
        return productRepository.findAllByStatusId(1L);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void setProductStatusAvailable(Long id, Rent rent) {
        boolean isBack = false;
        Product product = productRepository.getOne(id);
        product.setStatus(Status.builder().id(1L).name("Available").build());
        productRepository.save(product);
        for (RentedProducts rentedProd : rent.getRentedProductsDetails()) {
            if(rentedProd.getId().equals(id)){
                rentedProd.setStatus(Status.builder().id(1L).name("Available").build());
            }
            if (rentedProd.getStatus().getId() == 1) {
                isBack = true;
            }else{
                isBack = false;
                break;
            }

        }
        rent.setBack(isBack);
        rentRepository.save(rent);

    }
}


