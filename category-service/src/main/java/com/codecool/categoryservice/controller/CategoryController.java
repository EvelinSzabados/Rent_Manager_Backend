package com.codecool.categoryservice.controller;

import com.codecool.categoryservice.model.Category;
import com.codecool.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping("/all")
    public List<Category> listAllCategory(){return categoryService.getAllCategory();}
}
