package com.codecool.rent_manager.controller;

import com.codecool.rent_manager.model.Customer;
import com.codecool.rent_manager.model.Rent;
import com.codecool.rent_manager.repository.RentRepository;
import com.codecool.rent_manager.service.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerManager customerManager;
    @Autowired
    RentRepository rentRepository;

    @GetMapping("/all")
    public List<Customer> getAllCustomer() {
        return customerManager.listEveryCustomer();
    }

   @PutMapping("/modify")
    public void modifyCustomer(@RequestBody Customer customer) { customerManager.updateCustomer(customer); }

    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestBody Customer customer ){
        rentRepository.deleteByCustomer(customer);
        customerManager.deleteCustomer(customer); }

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer) {
        customerManager.addCustomer(customer);
    }
}
