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

/**
 * 
 * This class is the Leaf implementation of
 * {@link com.brenosalles.medication.MedicationComponent MedicationComponent}.
 * 
 * @author <a href="https://brenosalles.com" target="_blank">Breno</a>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
public class MedicationLeaf implements MedicationComponent {
    // Attributes
    private Double price;
    private MedicationLeafType type;

    // Methods
    /**
     * This function is used to get the
     * {@link com.brenosalles.medication.MedicationLeafType MedicationLeafType} of
     * the current object.
     * 
     * @return The type of the object.
     */
    public MedicationLeafType getType() {
        return this.type;
    }

    /**
     * This function is used to set the
     * {@link com.brenosalles.medication.MedicationLeafType MedicationLeafType} of
     * the current object.
     * 
     * @param type Contains the new
     *             {@link com.brenosalles.medication.MedicationLeafType
     *             MedicationLeafType}.
     */
    public void setType(MedicationLeafType type) {
        this.type = type;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    /**
     * This function is used to set a new price for the Medication.
     * 
     * @param price Contains the new price for the Medication.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.type.name();
    }
}