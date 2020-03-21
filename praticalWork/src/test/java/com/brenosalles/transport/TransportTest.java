package com.brenosalles.transport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import com.brenosalles.medication.MedicationLeaf;
import com.brenosalles.medication.MedicationLeafType;
import com.brenosalles.medication.MedicationComponent;
import com.brenosalles.medication.MedicationContainer;
import com.brenosalles.medication.MedicationContainerType;

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

        MedicationLeaf med = new MedicationLeaf();
        med.setType(MedicationLeafType.FRASCO);
        med.setPrice(2.0);
        medications.add(med);

        med = new MedicationLeaf();
        med.setType(MedicationLeafType.VACINA);
        med.setPrice(3.0);
        medications.add(med);

        med = new MedicationLeaf();
        med.setType(MedicationLeafType.COMPRIMIDO);
        med.setPrice(4.0);
        medications.add(med);

        MedicationContainer contentor = new MedicationContainer();
        contentor.setType(MedicationContainerType.CONTENTOR);
        contentor.addAllChilds(medications);

        Transport normal = new NormalTransport(contentor);

        Double expected = (2.0 + 3.0 + 4.0) * 0.05;

        assertEquals(expected, normal.getTransportCost());
    }

    @Test
    public void checkSpecialTransportPrice() {
        ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();

        MedicationLeaf med = new MedicationLeaf();
        med.setType(MedicationLeafType.FRASCO);
        med.setPrice(2.0);
        medications.add(med);

        med = new MedicationLeaf();
        med.setType(MedicationLeafType.VACINA);
        med.setPrice(3.0);
        medications.add(med);

        med = new MedicationLeaf();
        med.setType(MedicationLeafType.COMPRIMIDO);
        med.setPrice(4.0);
        medications.add(med);

        MedicationContainer contentor = new MedicationContainer();
        contentor.setType(MedicationContainerType.CONTENTOR);
        contentor.addAllChilds(medications);

        Transport special = new SpecialTransport(contentor);

        Double expected = (2.0 + 3.0 + 4.0) * 0.10;

        assertEquals(expected, special.getTransportCost());
    }
}