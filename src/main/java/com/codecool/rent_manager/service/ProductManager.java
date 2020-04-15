package com.codecool.rent_manager.service;

import com.codecool.rent_manager.model.CategoryRepository;
import com.codecool.rent_manager.model.ProcessedProduct;
import com.codecool.rent_manager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<ProcessedProduct> connectProductIdWithName(List<Product> inputList) {
        List<ProcessedProduct> processedList = new ArrayList<>();

        for (Product product : inputList) {

            // Find the category object by product's category id and then get the object's name
            String categoryName = categoryRepository.findById(product.getCategory_id()).getCategoryName();
            String statusName = "Available"; // burned in at the moment

            processedList.add(new ProcessedProduct(product.getId(), product.getName(), product.getPrice(),
                    product.getCategory_id(), product.getStatus_id(), categoryName, statusName));
        }

        return processedList;
    }
}
