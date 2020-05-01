package com.codecool.rent_manager.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Rent {
    protected @Getter @Setter int id;
    protected @Getter @Setter int customer_id;
    protected @Getter @Setter int cost;
    protected @Getter @Setter Date booking_date;
    protected @Getter @Setter Date start_date;
    protected @Getter @Setter Date end_date;

    public Rent(int id, int customer_id, int cost, Date booking_date, Date start_date, Date end_date) {
        this.id = id;
        this.customer_id = customer_id;
        this.cost = cost;
        this.booking_date = booking_date;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", cost=" + cost +
                ", booking_date=" + booking_date +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}


