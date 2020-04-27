package com.codecool.rent_manager.model;

import lombok.Getter;
import lombok.Setter;

public class Customer {

    protected @Getter @Setter int id;
    protected @Getter @Setter String first_name;
    protected @Getter @Setter String last_name;
    protected @Getter @Setter String email;
    protected @Getter @Setter String address;
    protected @Getter @Setter String phone_number;

    public Customer(int id, String first_name, String last_name, String email, String address, String phone_number) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
