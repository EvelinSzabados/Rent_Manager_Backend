package com.codecool.rent_manager.model;

import lombok.Getter;
import lombok.Setter;

public class Status { // table: statuses

    private @Getter @Setter int id;
    private @Getter @Setter String name;

    public Status(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
