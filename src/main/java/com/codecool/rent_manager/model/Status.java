package com.codecool.rent_manager.model;
import lombok.*;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "statuses")
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


}
