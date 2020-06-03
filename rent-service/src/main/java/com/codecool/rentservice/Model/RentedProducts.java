package com.codecool.rentservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentedProducts {
    private Long id;
    private String name;
    private int category_id;
    private int cost;
    private Status status;


}

