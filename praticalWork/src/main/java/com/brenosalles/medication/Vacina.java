package com.brenosalles.medication;

public class Vacina extends Medication {
    // Constructor
    protected Vacina(Double price) {
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