package com.codecool.rent_manager.service;

import com.codecool.rent_manager.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManager {
    /*
    This class is responsible for connecting Products
    with categories and statuses
     */

    public List<Product> connectProductsWithCategories(List<Product> inputList) {
        List<Product> processedList = new ArrayList<>();

        for (Product product : inputList) {

        }

        return processedList;
    }
}
