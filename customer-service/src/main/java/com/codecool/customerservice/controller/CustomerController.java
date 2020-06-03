package com.codecool.customerservice.controller;

import com.codecool.customerservice.model.Customer;
import com.codecool.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /* @Autowired
     RentRepository rentRepository;
 */
    @GetMapping("/all")
    public List<Customer> getAllCustomer() {
        return customerService.listEveryCustomer();
    }

    @PutMapping("/modify")
    public void modifyCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestBody Customer customer) {
        // rentRepository.deleteByCustomer(customer);
        customerService.deleteCustomer(customer);
    }

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }
}


