package com.codecool.rent_manager.repository;

import com.codecool.rent_manager.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RentRepository extends JpaRepository<Rent,Long> {

}
