package com.brenosalles.medication;

public class Comprimido extends Medication {
    // Constructor
    protected Comprimido(Double price) {
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