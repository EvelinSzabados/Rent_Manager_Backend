package com.codecool.rent_manager.repository;


import com.codecool.rent_manager.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
