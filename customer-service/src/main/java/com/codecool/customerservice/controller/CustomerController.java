package com.codecool.customerservice.controller;

import com.codecool.customerservice.model.Customer;
import com.codecool.customerservice.repository.CustomerRepository;
import com.codecool.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/all")
    public List<Customer> getAllCustomer() {
        return customerService.listEveryCustomer();
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable Long customerId){
        return customerRepository.findById(customerId);
    }

    @PutMapping("/modify")
    public void modifyCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestBody Customer customer) {
        //TODO: rentRepository.deleteByCustomer(customer);
        customerService.deleteCustomer(customer);
    }

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }
}


