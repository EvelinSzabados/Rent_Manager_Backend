package com.codecool.rent_manager.model;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface StatusRepository extends CrudRepository<Status, Long> {

    @Query("SELECT * FROM statuses WHERE id = :id")
    Status findById(@Param("id") int id);
}
