package com.codecool.rent_manager.service;


import com.codecool.rent_manager.model.Rent;
import com.codecool.rent_manager.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentManager {

    @Autowired
    RentRepository rentRepository;

    public List<Rent> listEveryRent() {
        return rentRepository.findAll();
    }

    public void updateRent(Rent rent){
        Rent rentToEdit = rentRepository.getOne(rent.getId());
        rentToEdit.setCost(rent.getCost());
        rentToEdit.setCustomer(rent.getCustomer());
        rentToEdit.setStart_date(rent.getStart_date());
        rentToEdit.setEnd_date(rent.getEnd_date());

        rentRepository.save(rentToEdit);

    }

    public void deleteRent(Rent rent){rentRepository.delete(rent);}

    public void addRent(Rent rent) {
        rentRepository.save(rent);
    }


}
