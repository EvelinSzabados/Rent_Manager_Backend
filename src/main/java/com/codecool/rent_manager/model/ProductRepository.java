package com.codecool.rent_manager.model;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT * FROM products")
    List<Product> getAll();

    @Query("SELECT * FROM products WHERE id = :id")
    Product find(@Param("id") int id);

    @Modifying
    @Query("UPDATE products SET price = :pr WHERE id = :id")
    void modifyPrice(@Param("pr") int price, @Param("id") int id);
}
