package com.codecool.rentservice.Repository;

import com.codecool.rentservice.Model.Customer;
import com.codecool.rentservice.Model.RentedProducts;
import com.codecool.rentservice.Model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ProductCaller {
    @Autowired
    RestTemplate restTemplate;
    @Value("${product-service.url}")
    public String baseUrl;


    public RentedProducts getRentedProductByRentId(String route) {
        ResponseEntity<RentedProducts> response =
                restTemplate.getForEntity(
                        baseUrl + route,
                        RentedProducts.class);
        return response.getBody();
    }

    public void updateProduct(String route,Long productId) {
        String url = baseUrl + route;

        RentedProducts product = getRentedProductByRentId("/" + productId);
        Status status = new Status(2L, "Rented");
        product.setStatus(status);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<RentedProducts> entity = new HttpEntity<>(product, headers);
        this.restTemplate.exchange(url, HttpMethod.PUT, entity, RentedProducts.class);

    }
}
