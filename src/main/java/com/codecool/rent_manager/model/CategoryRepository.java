package com.codecool.rent_manager.model;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("SELECT name FROM category WHERE id = :id")
    String findById(@Param("id") int id);

    @Query("SELECT * FROM category")
    String getAll();
}
