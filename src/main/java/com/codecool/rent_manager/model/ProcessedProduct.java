package com.codecool.rent_manager.model;

public class ProcessedProduct extends Product {

    private String categoryName;
    private String statusName;

    public ProcessedProduct(int id, String name, int price, String categoryName, String statusName) {
        super(id, name, price);
        this.categoryName = categoryName;
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "ProcessedProduct{" +
                "Id='" + id + '\'' +
                "Name='" + name + '\'' +
                "categoryName='" + categoryName + '\'' +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
