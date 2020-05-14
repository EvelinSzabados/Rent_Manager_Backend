package com.codecool.rent_manager.controller;

import com.codecool.rent_manager.model.Category;
import com.codecool.rent_manager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
