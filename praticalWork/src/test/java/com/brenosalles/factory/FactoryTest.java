package com.brenosalles.factory;

import static org.junit.Assert.assertEquals;

import com.brenosalles.medication.MedicationContainer;
import com.brenosalles.medication.MedicationContainerType;
import com.brenosalles.medication.MedicationLeaf;
import com.brenosalles.medication.MedicationLeafType;

import org.junit.Test;

public class FactoryTest {
    private MedicationFactory facLeaf = new MedicationLeafFactory();
    private MedicationFactory facContainer = new MedicationContainerFactory();

    @Test
    public void testMedicationLeafComprimidoCreate() throws UndefinedMedicationException, PoolExhaustedException {
        MedicationLeaf comprimido = (MedicationLeaf) facLeaf.createMedicationComponent("comprimido");
        assertEquals(MedicationLeafType.COMPRIMIDO, comprimido.getType());
    }

    @Test
    public void testMedicationLeafFrascoCreate() throws UndefinedMedicationException, PoolExhaustedException {
        MedicationLeaf frasco = (MedicationLeaf) facLeaf.createMedicationComponent("frasco");
        assertEquals(MedicationLeafType.FRASCO, frasco.getType());
    }

    @Test
    public void testMedicationLeafVacinaCreate() throws UndefinedMedicationException, PoolExhaustedException {
        MedicationLeaf vacina = (MedicationLeaf) facLeaf.createMedicationComponent("vacina");
        assertEquals(MedicationLeafType.VACINA, vacina.getType());
    }

    @Test(expected = UndefinedLeafException.class)
    public void testWrongMedicationLeafCreate() throws UndefinedMedicationException, PoolExhaustedException {
        facLeaf.createMedicationComponent("wrong");
    }

    @Test
    public void testMedicationContainerCaixaCreate() throws UndefinedMedicationException, PoolExhaustedException {
        MedicationContainer caixa = (MedicationContainer) facContainer.createMedicationComponent("caixa");
        assertEquals(MedicationContainerType.CAIXA, caixa.getType());
    }

    @Test
    public void testMedicationContainerContentorCreate() throws UndefinedMedicationException, PoolExhaustedException {
        MedicationContainer contentor = (MedicationContainer) facContainer.createMedicationComponent("contentor");
        assertEquals(MedicationContainerType.CONTENTOR, contentor.getType());
    }

    @Test
    public void testMedicationEmbalagemCaixaCreate() throws UndefinedMedicationException, PoolExhaustedException {
        MedicationContainer embalagem = (MedicationContainer) facContainer.createMedicationComponent("embalagem");
        assertEquals(MedicationContainerType.EMBALAGEM, embalagem.getType());
    }

    @Test(expected = UndefinedContainerException.class)
    public void testWrongMedicationContainerCreate() throws UndefinedMedicationException, PoolExhaustedException {
        facContainer.createMedicationComponent("wrong");
    }
}