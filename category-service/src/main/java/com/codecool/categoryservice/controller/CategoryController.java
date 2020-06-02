package com.codecool.categoryservice.controller;

import com.codecool.categoryservice.model.Category;
import com.codecool.categoryservice.repository.CategoryRepository;
import com.codecool.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping("/all")
    public List<Category> listAllCategory(){return categoryService.getAllCategory();}

    @GetMapping("/{categoryId}")
    public Optional<Category> getCategoryById(@PathVariable Long categoryId){

        return categoryRepository.findById(categoryId);
    }
}
