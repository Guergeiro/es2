package com.brenosalles.factory;

import com.brenosalles.medication.MedicationComponent;

public interface MedicationFactory {
    public MedicationComponent createMedicationComponent(String type)
            throws UndefinedMedicationException, PoolExhaustedException;
}