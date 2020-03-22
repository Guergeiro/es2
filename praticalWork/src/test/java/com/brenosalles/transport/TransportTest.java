/*
 * MIT License
 * 
 * Copyright (c) 2020 Breno Salles
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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

/**
 * 
 * @author <a href="https://brenosalles.com" target="_blank">Breno</a>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
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