package com.codecool.rentservice.Repository;

import com.codecool.rentservice.Model.Customer;
import com.codecool.rentservice.Model.RentedProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ProductCaller {
    @Autowired
    RestTemplate restTemplate;
    @Value("${customer-service.url}")
    public String baseUrl;


    public RentedProducts[] getRentedProductByRentId(String route) {
        ResponseEntity<RentedProducts[]> response =
                restTemplate.getForEntity(
                        baseUrl + route,
                        RentedProducts[].class);
        return response.getBody();
    }
}
