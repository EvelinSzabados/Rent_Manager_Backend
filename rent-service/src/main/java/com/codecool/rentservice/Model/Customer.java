package com.codecool.rentservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    private Long id;

    private String first_name;

    private String last_name;

    private String email;

    private String address;

    private String phone_number;
}
