package com.brenosalles.transport;

import com.brenosalles.medication.MedicationComponent;

public class SpecialTransport extends Transport {
    // Constructor
    public SpecialTransport(MedicationComponent medication) {
        super(medication);
    }

    // Methods
    @Override
    public Double getTransportCost() {
        return super.medication.getPrice() * 0.10;
    }
}