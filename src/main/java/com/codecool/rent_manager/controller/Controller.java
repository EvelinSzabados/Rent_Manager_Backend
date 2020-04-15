package com.codecool.rent_manager.controller;

import com.codecool.rent_manager.model.Category;
import com.codecool.rent_manager.model.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String currentCategory() {
        return categoryRepository.findById(3);
    }
}
