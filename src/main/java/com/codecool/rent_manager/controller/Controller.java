package com.codecool.rent_manager.controller;

import com.codecool.rent_manager.model.Category;
import com.codecool.rent_manager.model.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/category")
public class Controller {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/find{number}")
    public Category currentCategory(@PathVariable("number") int id) {
        return categoryRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }
}
