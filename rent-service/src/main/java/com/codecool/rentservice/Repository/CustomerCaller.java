package com.codecool.rentservice.Repository;

import com.codecool.rentservice.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Service
public class CustomerCaller {

    @Autowired
    RestTemplate restTemplate;
    @Value("${customer-service.url}")
    public String baseUrl;


    public Customer getCustomerById(String route) {
        ResponseEntity<Customer> response =
                restTemplate.getForEntity(
                        baseUrl + route,
                        Customer.class);
        return response.getBody();
    }
    public void updateCustomer(Customer customer) {
        String url = baseUrl + "/modify";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Customer> entity = new HttpEntity<>(customer, headers);
        this.restTemplate.exchange(url, HttpMethod.PUT, entity, Customer.class);

    }
}
