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
    // i stands for input
    @Query("UPDATE products " +
            "SET name = :iname, " +
            "price = :iprice, " +
            "category_id = :icategory_id, " +
            "status_id = :istatus_id" +
            " WHERE id = :id")
    void modifyProduct(@Param("iname") String name, @Param("iprice") int price,
                     @Param("icategory_id") int categoryId, @Param("istatus_id") int statusId,
                     @Param("id") int productId);
}
