package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String brand;
    private String model;

    public Smartphone () {
        super();
    }

    public Smartphone(int id, int price, String brand, String model) {
        super(id, price);
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}