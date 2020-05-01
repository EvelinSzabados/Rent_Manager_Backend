package com.codecool.rent_manager.repository;

import com.codecool.rent_manager.model.Rent;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface RentRepository extends CrudRepository<Rent,Long> {

    @Query("SELECT * FROM rents")
    List<Rent> getAll();


    @Modifying
    @Query("UPDATE rents " +
            "SET customer_id = :customer_id, " +
            "cost = :cost, " +
            "start_date = :start_date, " +
            "end_date = :end_date" +
            " WHERE id = :id")
    void modifyRent(@Param("customer_id") int customerId, @Param("cost") int cost,
                    @Param("start_date")Date start_date, @Param("end_date") Date end_date, @Param("id")int rentId);

    @Modifying
    @Query("DELETE FROM rents WHERE id= :id")
    void deleteRent(@Param("id")int id);

    @Modifying
    @Query("INSERT INTO rents (customer_id, cost, start_date, end_date) " +
            "VALUES (:customer_id, :cost, :start_date, :end_date)")
    void addRent(@Param("customer_id") int customerId, @Param("cost") int cost,
                    @Param("start_date")Date start_date, @Param("end_date") Date end_date);
}
