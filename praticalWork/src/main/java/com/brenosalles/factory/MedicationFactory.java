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

/**
 * 
 * This interface should be used to abstract the factories of
 * {@link com.brenosalles.medication.MedicationComponent MedicationComponent}.
 * 
 * @author <a href="https://brenosalles.com" target="_blank">Breno</a>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
public interface MedicationFactory {
    /**
     * This function should be used to implement a factory of
     * {@link com.brenosalles.medication.MedicationComponent MedicationComponent}.
     * 
     * @param type Contains the name of the component to create.
     * @return {@link com.brenosalles.medication.MedicationComponent
     *         MedicationComponent} Returns the required medication component.
     * @throws UndefinedMedicationException When an invalid
     *                                      {@link com.brenosalles.medication.MedicationComponent
     *                                      MedicationComponent} was asked.
     * @throws PoolExhaustedException       When one of the factories that use a
     *                                      Pool fails.
     */
    public MedicationComponent createMedicationComponent(String type)
            throws UndefinedMedicationException, PoolExhaustedException;
}