package com.brenosalles.medication;

import java.util.ArrayList;

public abstract class MedicationComposite implements MedicationComponent {
    // Attributes
    protected ArrayList<MedicationComponent> medications;

    // Constructor
    protected MedicationComposite(ArrayList<MedicationComponent> medications) {
        this.medications = new ArrayList<MedicationComponent>(medications);
    }

    // Methods
    public void addChild(MedicationComponent medication) {
        medications.add(medication);
    }

    public void removeChild(MedicationComponent medication) {
        medications.remove(medication);
    }
}