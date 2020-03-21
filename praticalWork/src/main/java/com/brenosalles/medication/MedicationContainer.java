package com.brenosalles.medication;

import java.util.ArrayList;

public class MedicationContainer implements MedicationComponent {
    // Attributes
    private ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
    private MedicationContainerType type;

    // Methods
    public void addChild(MedicationComponent medication) {
        this.medications.add(medication);
    }

    public void addAllChilds(ArrayList<MedicationComponent> medications) {
        this.medications.addAll(medications);
    }

    public void removeChild(MedicationComponent medication) {
        this.medications.remove(medication);
    }

    public void removeAllChilds() {
        this.medications.clear();
    }

    public MedicationContainerType getType() {
        return this.type;
    }

    public void setType(MedicationContainerType type) {
        this.type = type;
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
    public String toString() {
        String output = this.type.name();
        for (MedicationComponent medication : medications) {
            output += ("\n" + medication.toString());
        }
        return output;
    }
}