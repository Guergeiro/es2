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

package com.brenosalles.medication;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author <a href="https://brenosalles.com" target="_blank">Breno</a>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
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

        Double expected = 2.0 + 3.0 + 4.0;

        assertEquals(expected, contentor.getPrice());
    }

    @Test
    public void testOutputContentor() {
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

        String expected = "CONTENTOR\nFRASCO\nVACINA\nCOMPRIMIDO";

        assertEquals(expected, contentor.toString());
    }

    @Test
    public void testGetPriceCaixa() {
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

        MedicationContainer caixa = new MedicationContainer();
        caixa.setType(MedicationContainerType.CAIXA);
        caixa.addAllChilds(medications);

        Double expected = 2.0 + 3.0 + 4.0;

        assertEquals(expected, caixa.getPrice());
    }

    @Test
    public void testOutputCaixa() {
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

        MedicationContainer caixa = new MedicationContainer();
        caixa.setType(MedicationContainerType.CAIXA);
        caixa.addAllChilds(medications);

        String expected = "CAIXA\nFRASCO\nVACINA\nCOMPRIMIDO";

        assertEquals(expected, caixa.toString());
    }

    @Test
    public void testGetPriceEmbalagem() {
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

        MedicationContainer embalagem = new MedicationContainer();
        embalagem.setType(MedicationContainerType.EMBALAGEM);
        embalagem.addAllChilds(medications);

        Double expected = 2.0 + 3.0 + 4.0;

        assertEquals(expected, embalagem.getPrice());
    }

    @Test
    public void testOutputEmbalagem() {
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

        MedicationContainer embalagem = new MedicationContainer();
        embalagem.setType(MedicationContainerType.EMBALAGEM);
        embalagem.addAllChilds(medications);

        String expected = "EMBALAGEM\nFRASCO\nVACINA\nCOMPRIMIDO";

        assertEquals(expected, embalagem.toString());
    }
}
