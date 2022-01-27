package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String brand;

    public Smartphone () {
        super();
    }

    public Smartphone(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public boolean matches(String search) {
        if (super.matches(search) || getBrand().contains(search)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "brand='" + brand + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand);
    }
}