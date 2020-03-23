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

import com.brenosalles.medication.MedicationComponent;
import com.brenosalles.medication.MedicationLeaf;
import com.brenosalles.medication.MedicationLeafType;

/**
 * 
 * This class is responsible for creating objects of
 * {@link com.brenosalles.medication.MedicationLeaf MedicationLeaf}
 * 
 * @author <a href="https://brenosalles.com" target="_blank">Breno</a>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
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