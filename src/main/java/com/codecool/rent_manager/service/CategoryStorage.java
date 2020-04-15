package com.codecool.rent_manager.service;


import com.codecool.rent_manager.model.Category;
import com.codecool.rent_manager.model.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryStorage {

    @Autowired
    CategoryRepository categoryRepository;

    /**
    public Category findById(int id) {
        Category foundCategory;
        foundCategory = new Category(id, categoryRepository.findById(id));
        return foundCategory;
    }
     **/

    public List<Category> getAll() {
        List <Category> allCategory = new ArrayList<>();
        //Category cat = categoryRepository.getAll();
        return allCategory;
    }
}


