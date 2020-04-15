package com.codecool.rent_manager.controller;

import com.codecool.rent_manager.model.Category;
import com.codecool.rent_manager.model.CategoryRepository;
import com.codecool.rent_manager.service.CategoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class Controller {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryStorage categoryStorage;

    @GetMapping("/find{number}")
    public Category currentCategory(@PathVariable("number") int id) {
        return categoryStorage.findById(id);
    }

    @GetMapping("/all")
    public String getAllCategories() {
        return categoryRepository.getAll();
    }
}
