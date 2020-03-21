package com.brenosalles.medication;

public class MedicationLeaf implements MedicationComponent {
    // Attributes
    private Double price;
    private MedicationLeafType type;

    // Methods
    public MedicationLeafType getType() {
        return this.type;
    }

    public void setType(MedicationLeafType type) {
        this.type = type;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.type.name();
    }
}