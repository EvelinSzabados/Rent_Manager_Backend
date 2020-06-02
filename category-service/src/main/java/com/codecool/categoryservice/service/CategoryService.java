package com.codecool.categoryservice.service;

import com.codecool.categoryservice.model.Category;
import com.codecool.categoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;



    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
