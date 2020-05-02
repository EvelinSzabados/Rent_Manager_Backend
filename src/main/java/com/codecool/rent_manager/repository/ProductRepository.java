package com.codecool.rent_manager.repository;

import com.codecool.rent_manager.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findAllByStatusId(Long id);
}
