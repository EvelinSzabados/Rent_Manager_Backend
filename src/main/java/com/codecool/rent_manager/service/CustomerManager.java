package com.codecool.rent_manager.service;

import com.codecool.rent_manager.model.Customer;
import com.codecool.rent_manager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class CustomerManager {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> listEveryCustomer() {
        return customerRepository.getAll();
    }

    public void updateCustomer(@NotNull Customer customer) {
        String first_name = customer.getFirst_name();
        String last_name = customer.getLast_name();
        String email = customer.getEmail();
        String address = customer.getAddress();
        String phone_number = customer.getPhone_number();
        int id = customer.getId();
        customerRepository.modifyCustomer(first_name, last_name, email, address, phone_number, id);
    }

    public void deleteCustomer(@NotNull Customer customer) {
        int id = customer.getId();
        customerRepository.deleteCustomer(id);
    }

    public void addCustomer(Customer customer) {
        String first_name = customer.getFirst_name();
        String last_name = customer.getFirst_name();
        String email = customer.getEmail();
        String address = customer.getAddress();
        String phone_number = customer.getPhone_number();
        customerRepository.addCustomer(first_name, last_name, email, address, phone_number);
    }
}
