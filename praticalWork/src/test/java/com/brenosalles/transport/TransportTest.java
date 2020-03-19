package com.brenosalles.transport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import com.brenosalles.medication.Contentor;
import com.brenosalles.medication.Medication;
import com.brenosalles.medication.MedicationComponent;
import com.brenosalles.medication.MedicationComponentType;

import org.junit.Test;

public class TransportTest {
    @Test
    public void checkAbstractTransport() {
        assertTrue(Modifier.isAbstract(Transport.class.getModifiers()));
    }

    @Test
    public void checkProtectedConstructorTransport() throws NoSuchMethodException, SecurityException {
        assertTrue(
                Modifier.isProtected(Transport.class.getDeclaredConstructor(MedicationComponent.class).getModifiers()));
    }

    @Test
    public void checkProtectedAttributesTransport() throws NoSuchMethodException, SecurityException {
        for (Field attribute : Transport.class.getDeclaredFields()) {
            assertTrue(Modifier.isProtected(attribute.getModifiers()));
        }
    }

    @Test
    public void checkAbstractMethodTransport() throws NoSuchMethodException, SecurityException {
        assertTrue(Modifier.isAbstract(Transport.class.getDeclaredMethod("getTransportCost").getModifiers()));
    }

    @Test
    public void checkNormalTransportPrice() {
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
        Transport normal = new NormalTransport(contentor);

        Double expected = (2.0 + 3.0 + 4.0) * 0.05;

        assertEquals(expected, normal.getTransportCost());
    }

    @Test
    public void checkSpecialTransportPrice() {
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
        Transport special = new SpecialTransport(contentor);

        Double expected = (2.0 + 3.0 + 4.0) * 0.10;

        assertEquals(expected, special.getTransportCost());
    }
}