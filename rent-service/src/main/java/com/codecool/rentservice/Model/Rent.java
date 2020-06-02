package com.codecool.rentservice.Model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rents")
@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int customer_id;

    private int cost;

    @CreationTimestamp
    private Date booking_date;

    private LocalDate start_date;

    @Column(name="isback")
    private boolean isBack;

    @Column(name="enddate")
    private LocalDate endDate;

    @ElementCollection
    @Singular
    @CollectionTable(name = "rented_products", joinColumns = @JoinColumn(name = "rent_id"))
    @Column(name = "products")
    private List<String> rentedProducts;

    @Transient
    private Customer customer;
    @Transient
    private List<RentedProducts> rentedProductsDetails;

}
