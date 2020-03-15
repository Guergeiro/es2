package com.brenosalles.transport;

import com.brenosalles.medication.MedicationComponent;

public class NormalTransport extends Transport {
    // Constructor
    public NormalTransport(MedicationComponent medication) {
        super(medication);
    }

    // Methods
    @Override
    public Double getTransportCost() {
        return medication.getPrice() * 0.05;
    }
}