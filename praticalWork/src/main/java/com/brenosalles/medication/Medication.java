package com.brenosalles.medication;

public class Medication implements MedicationComponent {
    // Attributes
    private Double price;
    private MedicationComponentType type;

    // Constructor
    public Medication(MedicationComponentType type) {
        this.price = 0.0;
        this.type = type;
    }

    // Methods
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public MedicationComponentType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.name();
    }
}