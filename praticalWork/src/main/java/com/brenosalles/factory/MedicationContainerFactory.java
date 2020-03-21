package com.brenosalles.factory;

import com.brenosalles.medication.MedicationComponent;
import com.brenosalles.medication.MedicationContainer;
import com.brenosalles.medication.MedicationContainerType;

public class MedicationContainerFactory implements MedicationFactory {
    @Override
    public MedicationComponent createMedicationComponent(String type)
            throws UndefinedContainerException, PoolExhaustedException {
        switch (type.toUpperCase()) {
            case "CAIXA":
                return CaixaPool.getInstance().acquire();
            case "CONTENTOR":
                return ContentorPool.getInstance().acquire();
            case "EMBALAGEM":
                MedicationContainer embalagem = new MedicationContainer();
                embalagem.setType(MedicationContainerType.EMBALAGEM);
                return embalagem;
            default:
                throw new UndefinedContainerException();
        }
    }
}