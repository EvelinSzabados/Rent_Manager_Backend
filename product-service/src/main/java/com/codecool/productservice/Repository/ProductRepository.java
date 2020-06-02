package com.codecool.productservice.Repository;

import com.codecool.productservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByStatusId(long l);
}
