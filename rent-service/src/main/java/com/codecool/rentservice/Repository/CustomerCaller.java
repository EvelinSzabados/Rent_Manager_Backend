package com.codecool.rentservice.Repository;

import com.codecool.rentservice.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CustomerCaller {

    @Autowired
    RestTemplate restTemplate;
    @Value("${customerservice.url}")
    public String baseUrl;


    public Customer getCustomerById(String route) {
        ResponseEntity<Customer> response =
                restTemplate.getForEntity(
                        baseUrl + route,
                        Customer.class);
        return response.getBody();
    }
}
