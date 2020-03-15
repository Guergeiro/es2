package com.brenosalles.transport;

import com.brenosalles.medication.MedicationComponent;

public abstract class Transport {
    // Attributes
    protected MedicationComponent medication;

    // Constructor
    protected Transport(MedicationComponent medication) {
        this.medication = medication;
    }

    // Methods
    public abstract Double getTransportCost();
}