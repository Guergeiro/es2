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

package com.brenosalles.factory;

import static org.junit.Assert.assertEquals;

import com.brenosalles.medication.MedicationContainer;
import com.brenosalles.medication.MedicationContainerType;
import com.brenosalles.medication.MedicationLeaf;
import com.brenosalles.medication.MedicationLeafType;

import org.junit.Test;

/**
 * 
 * @author <a href="https://brenosalles.com" target="_blank">Breno</a>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
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