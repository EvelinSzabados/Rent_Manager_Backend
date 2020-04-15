package com.codecool.rent_manager;

import com.codecool.rent_manager.model.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RentManagerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(RentManagerApplication.class);

    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(RentManagerApplication.class, args);
    }



}
