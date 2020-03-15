package com.brenosalles.medication;

public class Frasco extends Medication {
    // Constructor
    public Frasco(Double price) {
        super(price);
    }

    // Methods
    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}