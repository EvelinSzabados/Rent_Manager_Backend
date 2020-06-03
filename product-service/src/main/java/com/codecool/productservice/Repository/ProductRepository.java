package com.codecool.productservice.Repository;

import com.codecool.productservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByStatusId(long l);

    Optional<Product> findById(Long aLong);
}
