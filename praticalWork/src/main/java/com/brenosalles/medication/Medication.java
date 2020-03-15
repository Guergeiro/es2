package com.brenosalles.medication;

public abstract class Medication implements MedicationComponent {
    // Attributes
    protected Double price;

    // Constructor
    protected Medication(Double price) {
        this.price = price;
    }
}