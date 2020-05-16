package com.codecool.rent_manager.repository;

import com.codecool.rent_manager.model.Customer;
import com.codecool.rent_manager.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RentRepository extends JpaRepository<Rent,Long> {

    void deleteByCustomer(Customer customer);


}
