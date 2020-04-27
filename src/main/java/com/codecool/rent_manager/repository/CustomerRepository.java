package com.codecool.rent_manager.repository;

import com.codecool.rent_manager.model.Customer;
import com.codecool.rent_manager.model.Product;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Product, Long> {

    @Query("SELECT * FROM customers")
    List<Customer> getAll();

    @Modifying
    @Query("UPDATE customers " +
            "SET first_name = :first_name, " +
            "last_name = :last_name," +
            "email = :email," +
            "address = :address," +
            "phone_number = :phone_number" +
            " WHERE id = :id")
    void modifyCustomer(@Param("first_name") String first_name, @Param("last_name") String last_name,
                        @Param("email") String email, @Param("address") String address,
                        @Param("phone_number") String phone_number,
                        @Param("id") int customerId);

    @Modifying
    @Query("DELETE FROM customers WHERE id= :id")
    void deleteCustomer(@Param("id") int id);

    @Modifying
    @Query("INSERT INTO customers (first_name, last_name, email, address, phone_number) " +
            "VALUES (:first_name, :last_name, :email, :address, :phone_number)")
    void addCustomer(@Param("first_name") String first_name, @Param("last_name") String last_name,
                     @Param("email") String email, @Param("address") String address,
                     @Param("phone_number") String phone_number);
}
