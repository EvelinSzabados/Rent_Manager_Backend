package com.codecool.rent_manager.model;

public class Product { // table: products
    private int id;
    private String name;
    private int price;
    private int category_id;
    private int status_id;

    public Product(int id, String name, int price, int category_id, int status_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category_id = category_id;
        this.status_id = status_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category_id=" + category_id +
                ", status_id=" + status_id +
                '}';
    }
}
