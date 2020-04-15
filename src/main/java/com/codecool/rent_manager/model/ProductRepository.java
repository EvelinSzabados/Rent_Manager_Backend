package com.codecool.rent_manager.model;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT * FROM products")
    List<Product> getAll();
}
