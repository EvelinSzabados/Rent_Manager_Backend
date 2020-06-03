package com.codecool.rentservice.Repository;

import com.codecool.rentservice.Model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentRepository extends JpaRepository<Rent,Long> {
    List<Rent> findByEndDateIsLessThanEqual(LocalDate date);
}
