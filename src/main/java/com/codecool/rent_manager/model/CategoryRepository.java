package com.codecool.rent_manager.model;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("SELECT id, category_name FROM category WHERE id = :id")
    Category findById(@Param("id") int id);

    @Query("SELECT * FROM category")
    List<Category> getAll();
}
