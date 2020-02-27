package com.es2.factorymethod;

public class Computer implements Product {
    // Attributes
    private String brand;

    protected Computer() {

    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }
}
