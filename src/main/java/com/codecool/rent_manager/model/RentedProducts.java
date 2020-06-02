package com.codecool.rent_manager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentedProducts {
    private Long id;
    private String name;
    private int cost;
    private Status status;
}
