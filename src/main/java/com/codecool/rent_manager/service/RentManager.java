package com.codecool.rent_manager.service;

import com.codecool.rent_manager.model.Customer;
import com.codecool.rent_manager.model.Rent;
import com.codecool.rent_manager.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Service
public class RentManager {

    @Autowired
    RentRepository rentRepository;

    public List<Rent> listEveryRent() {
        return rentRepository.getAll();
    }

    public void updateRent(@NotNull Rent rent) {

        int customer_id = rent.getCustomer_id();
        int cost = rent.getCost();
        Date start_date = rent.getStart_date();
        Date end_date = rent.getEnd_date();
        int id = rent.getId();
        rentRepository.modifyRent(customer_id,cost,start_date,end_date,id);
    }


    public void deleteRent(@NotNull Rent rent) {
        int id = rent.getId();
        rentRepository.deleteRent(id);
    }

    public void addRent(Rent rent) {
        int customer_id = rent.getCustomer_id();
        int cost = rent.getCost();
        Date start_date = rent.getStart_date();
        Date end_date = rent.getEnd_date();
        rentRepository.addRent(customer_id,cost,start_date,end_date);
    }
}
