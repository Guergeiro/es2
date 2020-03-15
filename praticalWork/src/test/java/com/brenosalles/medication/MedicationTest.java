package com.brenosalles.medication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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
    public void checkAbstractMedicationComposite() {
        assertTrue(Modifier.isAbstract(MedicationComposite.class.getModifiers()));
    }

    @Test
    public void checkProtectedConstructorMedicationComposite() throws NoSuchMethodException, SecurityException {
        assertTrue(
                Modifier.isProtected(MedicationComposite.class.getDeclaredConstructor(ArrayList.class).getModifiers()));
    }

    @Test
    public void checkProtectedAttributesMedicationComposite() {
        for (Field attribute : MedicationComposite.class.getDeclaredFields()) {
            assertTrue(Modifier.isProtected(attribute.getModifiers()));
        }
    }

    @Test
    public void checkAbstractMedication() {
        assertTrue(Modifier.isAbstract(Medication.class.getModifiers()));
    }

    @Test
    public void checkProtectedConstructorMedication() throws NoSuchMethodException, SecurityException {
        assertTrue(Modifier.isProtected(Medication.class.getDeclaredConstructor(Double.class).getModifiers()));
    }

    @Test
    public void checkProtectedAttributesMedication() {
        for (Field attribute : Medication.class.getDeclaredFields()) {
            assertTrue(Modifier.isProtected(attribute.getModifiers()));
        }
    }

    @Test
    public void testGetPriceContentor() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
        medications.add(new Frasco(2.0));
        medications.add(new Comprimido(3.0));
        medications.add(new Vacina(4.0));

        MedicationComponent contentor = new Contentor(medications);

        assertTrue(2.0 + 3.0 + 4.0 == contentor.getPrice());
    }

    @Test
    public void testOutputContentor() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
        medications.add(new Frasco(2.0));
        medications.add(new Comprimido(3.0));
        medications.add(new Vacina(4.0));

        MedicationComponent contentor = new Contentor(medications);

        String expected = "Contentor\nFrasco\nComprimido\nVacina";

        assertEquals(expected, contentor.toString());
    }

    @Test
    public void testGetPriceCaixa() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
        medications.add(new Frasco(2.0));
        medications.add(new Comprimido(3.0));
        medications.add(new Vacina(4.0));

        MedicationComponent caixa = new Caixa(medications);

        assertTrue(2.0 + 3.0 + 4.0 == caixa.getPrice());
    }

    @Test
    public void testOutputCaixa() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
        medications.add(new Frasco(2.0));
        medications.add(new Comprimido(3.0));
        medications.add(new Vacina(4.0));

        MedicationComponent caixa = new Caixa(medications);

        String expected = "Caixa\nFrasco\nComprimido\nVacina";

        assertEquals(expected, caixa.toString());
    }

    @Test
    public void testGetPriceEmbalagem() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
        medications.add(new Frasco(2.0));
        medications.add(new Comprimido(3.0));
        medications.add(new Vacina(4.0));

        MedicationComponent embalagem = new Embalagem(medications);

        assertTrue(2.0 + 3.0 + 4.0 == embalagem.getPrice());
    }

    @Test
    public void testOutputEmbalagem() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
        medications.add(new Frasco(2.0));
        medications.add(new Comprimido(3.0));
        medications.add(new Vacina(4.0));

        MedicationComponent embalagem = new Embalagem(medications);

        String expected = "Embalagem\nFrasco\nComprimido\nVacina";

        assertEquals(expected, embalagem.toString());
    }
}
