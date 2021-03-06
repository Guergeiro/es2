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
import com.brenosalles.medication.MedicationContainer;
import com.brenosalles.medication.MedicationContainerType;

/**
 * 
 * This class is responsible for creating objects of
 * {@link com.brenosalles.medication.MedicationContainer MedicationContainer}
 * 
 * @author <a href="https://brenosalles.com" target="_blank">Breno</a>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
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