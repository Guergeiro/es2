package com.brenosalles.medication;

import java.util.ArrayList;

public class Embalagem extends MedicationComposite {
    // Constructor
    public Embalagem() {
        super();
    }

    public Embalagem(ArrayList<MedicationComponent> medications) {
        super(medications);
    }

    // Methods
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
        String output = this.getClass().getSimpleName();
        for (MedicationComponent medication : medications) {
            output += ("\n" + medication.toString());
        }
        return output;
    }
}