package com.brenosalles.factory;

import java.util.ArrayList;

import com.brenosalles.medication.MedicationContainer;
import com.brenosalles.medication.MedicationContainerType;

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

    public synchronized void release(MedicationContainer caixa) throws ObjectNotFoundException {
        if (used.contains(caixa) == false) {
            throw new ObjectNotFoundException();
        }
        used.remove(caixa);
        free.add(caixa);
    }

    public synchronized void resetPool() {
        this.free.clear();
        this.used.clear();
    }

    public synchronized void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}