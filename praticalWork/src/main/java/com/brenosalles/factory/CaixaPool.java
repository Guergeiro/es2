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

import java.util.ArrayList;

import com.brenosalles.medication.MedicationContainer;
import com.brenosalles.medication.MedicationContainerType;

/**
 * 
 * This class is a singleton class responsible for storing a pool of "Caixa".
 * 
 * @author <a href="https://brenosalles.com" target="_blank">Breno</a>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
public class CaixaPool {
    // Attributes
    private static CaixaPool instance;
    private Integer maxSize = 10;
    private ArrayList<MedicationContainer> free = new ArrayList<MedicationContainer>();
    private ArrayList<MedicationContainer> used = new ArrayList<MedicationContainer>();

    // Constructor
    private CaixaPool() {
        /** Intentionally empty */
    }

    // Methods
    /**
     * This function is used to retrieve the singleton instance of this class.
     * 
     * @return {@link com.brenosalles.factory.CaixaPool CaixaPool} contains the
     *         class instance.
     */
    public static CaixaPool getInstance() {
        if (instance == null) {
            synchronized (CaixaPool.class) {
                if (instance == null) {
                    instance = new CaixaPool();
                }
            }
        }
        return instance;
    }

    /**
     * This function is used to retrieve either an available object from the pool or
     * a new object.
     * 
     * @return {@link com.brenosalles.medication.MedicationContainer Caixa}.
     * @throws PoolExhaustedException When it's impossible create new objects.
     */
    public synchronized MedicationContainer acquire() throws PoolExhaustedException {
        if (used.size() >= maxSize) {
            // Atingiu-se limite de connections
            throw new PoolExhaustedException();
        }

        MedicationContainer caixa = null;
        if (free.isEmpty() == true) {
            // No object available
            caixa = new MedicationContainer();
            caixa.setType(MedicationContainerType.CAIXA);
        } else {
            caixa = free.get(0);
            free.remove(0);
        }
        used.add(caixa);
        return caixa;
    }

    /**
     * This function is used to release an object and put it available in the pool
     * 
     * @param caixa Contains the object we want to release.
     * @throws ObjectNotFoundException When the object we are trying to release was
     *                                 not created by this pool.
     */
    public synchronized void release(MedicationContainer caixa) throws ObjectNotFoundException {
        if (used.contains(caixa) == false) {
            throw new ObjectNotFoundException();
        }
        used.remove(caixa);
        free.add(caixa);
        caixa.removeAllChilds();
    }

    /**
     * This fucntion is used to clear the pool, allowing the garbage collector to
     * clean the objects.
     */
    public synchronized void resetPool() {
        this.free.clear();
        this.used.clear();
    }

    /**
     * This function is used to change the size of the pool.
     * 
     * @param maxSize Contains the new size for the pool.
     */
    public synchronized void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}