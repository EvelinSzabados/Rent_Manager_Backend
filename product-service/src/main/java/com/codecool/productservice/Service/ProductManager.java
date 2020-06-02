package com.codecool.productservice.Service;

import com.codecool.productservice.Model.Category;
import com.codecool.productservice.Model.Product;
import com.codecool.productservice.Repository.CategoryCaller;
import com.codecool.productservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductManager {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryCaller categoryCaller;

//    @Autowired
//    private RentRepository rentRepository;

    public List<Product> productList() {
        List<Product> allProduct = productRepository.findAll();
        for (Product product : allProduct) {
            Category category = categoryCaller.getCategoryById("/" + product.getCategory_id());
            product.setCategory(category);
        }


        return productRepository.findAll();
    }


    public void updateProduct(Product product) {
        Product productToEdit = productRepository.getOne(product.getId());
        productToEdit.setName(product.getName());
        productToEdit.setPrice(product.getPrice());
        productToEdit.setStatus(product.getStatus());
        productRepository.save(productToEdit);
    }

    public List<Product> getAvailableProducts() {
        List<Product> allProduct = productRepository.findAllByStatusId(1L);
        for (Product product : allProduct) {
            Category category = categoryCaller.getCategoryById("/" + product.getCategory_id());
            product.setCategory(category);
        }
        return allProduct;
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

//    public void setProductStatusAvailable(Long id, Rent rent) {
//        boolean isBack = false;
//        Product product = productRepository.getOne(id);
//        product.setStatus(Status.builder().id(1L).name("Available").build());
//        productRepository.save(product);
//        for (RentedProducts rentedProd : rent.getRentedProductsDetails()) {
//            if(rentedProd.getId().equals(id)){
//                rentedProd.setStatus(Status.builder().id(1L).name("Available").build());
//            }
//            if (rentedProd.getStatus().getId() == 1) {
//                isBack = true;
//            }else{
//                isBack = false;
//                break;
//            }
//
//        }
//        rent.setBack(isBack);
//        rentRepository.save(rent);
//
//    }
}



