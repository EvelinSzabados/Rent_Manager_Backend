package com.codecool.rent_manager.service;


import com.codecool.rent_manager.model.Product;
import com.codecool.rent_manager.model.Rent;
import com.codecool.rent_manager.model.Status;
import com.codecool.rent_manager.repository.ProductRepository;
import com.codecool.rent_manager.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentManager {

    @Autowired
    RentRepository rentRepository;

    @Autowired
    ProductRepository productRepository;


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

//    public void calculateRentCost(Rent rent, Optional<Product> productToEdit){
//        int daysOfRent = rent.getEnd_date().compareTo(rent.getStart_date());
//        int costPerProduct = productToEdit.get().getPrice() * daysOfRent;
//        rent.setCost(rent.getCost()+ costPerProduct);
//    }

    public void addRent(Rent rent) {

        List<String> rented_products = rent.getRentedProducts();
        for (String actualProduct : rented_products) {
            Optional<Product> productToEdit = productRepository.findById(Long.valueOf(actualProduct));
            Status status = new Status(2L, "Rented");
            productToEdit.get().setStatus(status);
//            calculateRentCost(rent,productToEdit);
            rentRepository.save(rent);
        }

    }
}
