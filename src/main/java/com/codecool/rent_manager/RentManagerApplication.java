package com.codecool.rent_manager;

import com.codecool.rent_manager.model.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentManagerApplication {

    // Use this logger if you need it
    //private static final Logger LOGGER = LoggerFactory.getLogger(RentManagerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RentManagerApplication.class, args);
    }



}
