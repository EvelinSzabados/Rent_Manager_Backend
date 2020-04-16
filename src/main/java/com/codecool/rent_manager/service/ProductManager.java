package com.codecool.rent_manager.service;

import com.codecool.rent_manager.model.CategoryRepository;
import com.codecool.rent_manager.model.ProcessedProduct;
import com.codecool.rent_manager.model.Product;
import com.codecool.rent_manager.model.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManager {
    /*
    This class is responsible for connecting Products
    with categories and statuses
     */

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    StatusRepository statusRepository;

    //TODO: Check out if you can join the products with a single query, then this function will be unnecessary

    public List<ProcessedProduct> connectProductIdWithName(@NotNull List<Product> inputList) {
        List<ProcessedProduct> processedList = new ArrayList<>();

        for (Product product : inputList) {

            // Find the category object by product's category/status id and then get the object's name
            String categoryName = categoryRepository.findById(product.getCategory_id()).getCategoryName();
            String statusName = statusRepository.findById(product.getStatus_id()).getName();

            // Instantiate a new ProcessedProduct object and put it in the list
            processedList.add(new ProcessedProduct(product.getId(), product.getName(), product.getPrice(),
                    product.getCategory_id(), product.getStatus_id(), categoryName, statusName));
        }

        return processedList;
    }
}
