package com.codecool.categoryservice.repository;

import com.codecool.categoryservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
