package com.codecool.rent_manager.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rents")
@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    private int cost;

    @CreationTimestamp
    private Date booking_date;

    private LocalDate start_date;

    @Column(name="enddate")
    private LocalDate endDate;

    @ElementCollection
    @Singular
    @CollectionTable(name = "rented_products", joinColumns = @JoinColumn(name = "rent_id"))
    @Column(name = "products")
    private List<String> rentedProducts;

    @Transient
    private List<RentedProducts> rentedProductsDetails;
}


