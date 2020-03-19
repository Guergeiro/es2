package com.brenosalles.medication;

import java.util.ArrayList;

public abstract class MedicationComposite implements MedicationComponent {
    // Attributes
    private ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
    protected MedicationComponentType type;

    // Constructor
    protected MedicationComposite() {
        /** Intentionally Empty */
    }

    // Methods
    public void addChild(MedicationComponent medication) {
        medications.add(medication);
    }

    public void addAllChilds(ArrayList<MedicationComponent> medications) {
        this.medications.addAll(medications);
    }

    public void removeChild(MedicationComponent medication) {
        medications.remove(medication);
    }

    public void removeAllChilds() {
        medications.clear();
    }

    @Override
    public Double getPrice() {
        Double output = 0.0;
        for (MedicationComponent medication : medications) {
            output += medication.getPrice();
        }
        return output;
    }

    @Override
    public MedicationComponentType getType() {
        return type;
    }

    @Override
    public String toString() {
        String output = type.name();
        for (MedicationComponent medication : medications) {
            output += ("\n" + medication.toString());
        }
        return output;
    }
}