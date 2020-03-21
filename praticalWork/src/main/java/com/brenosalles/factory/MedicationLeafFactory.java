package com.brenosalles.factory;

import com.brenosalles.medication.MedicationComponent;
import com.brenosalles.medication.MedicationLeaf;
import com.brenosalles.medication.MedicationLeafType;

public class MedicationLeafFactory implements MedicationFactory {
    @Override
    public MedicationComponent createMedicationComponent(String type) throws UndefinedMedicationException {
        switch (type.toUpperCase()) {
            case "COMPRIMIDO":
                MedicationLeaf comprimido = new MedicationLeaf();
                comprimido.setType(MedicationLeafType.COMPRIMIDO);
                return comprimido;
            case "VACINA":
                MedicationLeaf vacina = new MedicationLeaf();
                vacina.setType(MedicationLeafType.VACINA);
                return vacina;
            case "FRASCO":
                MedicationLeaf frasco = new MedicationLeaf();
                frasco.setType(MedicationLeafType.FRASCO);
                return frasco;
            default:
                throw new UndefinedLeafException();
        }
    }
}