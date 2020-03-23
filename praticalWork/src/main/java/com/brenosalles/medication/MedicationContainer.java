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

import java.util.ArrayList;

/**
 * 
 * This class is the Composite implementation of
 * {@link com.brenosalles.medication.MedicationComponent MedicationComponent}.
 * 
 * @author <a href="https://brenosalles.com" target="_blank">Breno</a>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
public class MedicationContainer implements MedicationComponent {
    // Attributes
    private ArrayList<MedicationComponent> medications = new ArrayList<MedicationComponent>();
    private MedicationContainerType type;

    // Methods
    /**
     * This function is used to add a
     * {@link com.brenosalles.medication.MedicationComponent child}.
     * 
     * @param medication Contains the child we want to add.
     */
    public void addChild(MedicationComponent medication) {
        this.medications.add(medication);
    }

    /**
     * This function is used to add multiple
     * {@link com.brenosalles.medication.MedicationComponent childs}.
     * 
     * @param medications Contains an ArrayList of childs.
     */
    public void addAllChilds(ArrayList<MedicationComponent> medications) {
        this.medications.addAll(medications);
    }

    /**
     * This function is used to remove a
     * {@link com.brenosalles.medication.MedicationComponent child}.
     * 
     * @param medication Contains the child we want to remove.
     */
    public void removeChild(MedicationComponent medication) {
        this.medications.remove(medication);
    }

    /**
     * This function is used to remove all
     * {@link com.brenosalles.medication.MedicationComponent childs}.
     */
    public void removeAllChilds() {
        this.medications.clear();
    }

    /**
     * This function is used to get the
     * {@link com.brenosalles.medication.MedicationContainerType
     * MedicationContainerType} of the current object.
     * 
     * @return The type of the object.
     */
    public MedicationContainerType getType() {
        return this.type;
    }

    /**
     * This function is used to set the
     * {@link com.brenosalles.medication.MedicationContainerType
     * MedicationContainerType} of the current object.
     * 
     * @param type Contains the new
     *             {@link com.brenosalles.medication.MedicationContainerType
     *             MedicationContainerType}.
     */
    public void setType(MedicationContainerType type) {
        this.type = type;
    }

    @Override
    public Double getPrice() {
        Double output = 0.0;
        for (MedicationComponent medication : medications) {
            output += medication.getPrice();
        }
        return output;
    }

    @Override
    public String toString() {
        String output = this.type.name();
        for (MedicationComponent medication : medications) {
            output += ("\n" + medication.toString());
        }
        return output;
    }
}