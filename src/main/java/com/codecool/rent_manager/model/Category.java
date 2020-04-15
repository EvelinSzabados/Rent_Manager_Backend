package com.codecool.rent_manager.model;

import lombok.Getter;
import lombok.Setter;

public class Category { //table: category


    private @Getter @Setter int id;
    private @Getter @Setter String categoryName;

    public Category(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
