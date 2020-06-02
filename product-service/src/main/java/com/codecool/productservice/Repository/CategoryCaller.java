package com.codecool.productservice.Repository;

import com.codecool.productservice.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryCaller {

    @Autowired
    RestTemplate restTemplate;

    @Value("${category-service.url}")
    public String baseUrl;

    public Category getCategoryById(String route) {
        ResponseEntity<Category> response =
                restTemplate.getForEntity(
                        baseUrl + route,
                        Category.class);
        return response.getBody();
    }
}
