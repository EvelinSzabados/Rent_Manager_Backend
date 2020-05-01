package com.codecool.rent_manager.service;

import com.codecool.rent_manager.model.Customer;
import com.codecool.rent_manager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> listEveryCustomer() {
        return customerRepository.findAll();
    }



    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public void addCustomer(Customer customer) {
      customerRepository.save(customer);
    }
}
