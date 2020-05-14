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

    public void updateCustomer(Customer customer){
        Customer customerToEdit = customerRepository.getOne(customer.getId());
        customerToEdit.setAddress(customer.getAddress());
        customerToEdit.setEmail(customer.getEmail());
        customerToEdit.setFirst_name(customer.getFirst_name());
        customerToEdit.setLast_name(customer.getLast_name());
        customerToEdit.setPhone_number(customer.getPhone_number());

        customerRepository.save(customerToEdit);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public void addCustomer(Customer customer) {
      customerRepository.save(customer);
    }
}
