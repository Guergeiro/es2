package com.brenosalles.medication;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MedicationTest {
    // Attributes
    private static ByteArrayOutputStream outContent;
    private static PrintStream originalOut;

    @BeforeClass
    public static void prepareBuffer() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterClass
    public static void resetBuffer() {
        System.setOut(originalOut);
    }

    @Test
    public void testGetPriceContentor() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();

        Medication med = new Medication(MedicationComponentType.FRASCO);
        med.setPrice(2.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.VACINA);
        med.setPrice(3.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.COMPRIMIDO);
        med.setPrice(4.0);
        medications.add(med);

        Contentor contentor = new Contentor();
        contentor.addAllChilds(medications);

        Double expected = 2.0 + 3.0 + 4.0;

        assertEquals(expected, contentor.getPrice());
    }

    @Test
    public void testOutputContentor() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
        Medication med = new Medication(MedicationComponentType.FRASCO);
        med.setPrice(2.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.VACINA);
        med.setPrice(3.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.COMPRIMIDO);
        med.setPrice(4.0);
        medications.add(med);

        Contentor contentor = new Contentor();
        contentor.addAllChilds(medications);

        String expected = "CONTENTOR\nFRASCO\nVACINA\nCOMPRIMIDO";

        assertEquals(expected, contentor.toString());
    }

    @Test
    public void testGetPriceCaixa() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
        Medication med = new Medication(MedicationComponentType.FRASCO);
        med.setPrice(2.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.VACINA);
        med.setPrice(3.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.COMPRIMIDO);
        med.setPrice(4.0);
        medications.add(med);

        Caixa caixa = new Caixa();
        caixa.addAllChilds(medications);

        Double expected = 2.0 + 3.0 + 4.0;

        assertEquals(expected, caixa.getPrice());
    }

    @Test
    public void testOutputCaixa() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
        Medication med = new Medication(MedicationComponentType.FRASCO);
        med.setPrice(2.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.VACINA);
        med.setPrice(3.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.COMPRIMIDO);
        med.setPrice(4.0);
        medications.add(med);

        Caixa caixa = new Caixa();
        caixa.addAllChilds(medications);

        String expected = "CAIXA\nFRASCO\nVACINA\nCOMPRIMIDO";

        assertEquals(expected, caixa.toString());
    }

    @Test
    public void testGetPriceEmbalagem() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
        Medication med = new Medication(MedicationComponentType.FRASCO);
        med.setPrice(2.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.VACINA);
        med.setPrice(3.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.COMPRIMIDO);
        med.setPrice(4.0);
        medications.add(med);

        Embalagem embalagem = new Embalagem();
        embalagem.addAllChilds(medications);

        Double expected = 2.0 + 3.0 + 4.0;

        assertEquals(expected, embalagem.getPrice());
    }

    @Test
    public void testOutputEmbalagem() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
        Medication med = new Medication(MedicationComponentType.FRASCO);
        med.setPrice(2.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.VACINA);
        med.setPrice(3.0);
        medications.add(med);

        med = new Medication(MedicationComponentType.COMPRIMIDO);
        med.setPrice(4.0);
        medications.add(med);

        Embalagem embalagem = new Embalagem();
        embalagem.addAllChilds(medications);

        String expected = "EMBALAGEM\nFRASCO\nVACINA\nCOMPRIMIDO";

        assertEquals(expected, embalagem.toString());
    }
}
