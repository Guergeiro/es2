package com.brenosalles.factory;

import java.util.ArrayList;

import com.brenosalles.medication.MedicationContainer;
import com.brenosalles.medication.MedicationContainerType;

public class ContentorPool {
    // Attributes
    private static ContentorPool instance;
    private Integer maxSize = 10;
    private ArrayList<MedicationContainer> free = new ArrayList<MedicationContainer>();
    private ArrayList<MedicationContainer> used = new ArrayList<MedicationContainer>();

    // Constructor
    private ContentorPool() {
        /** Intentionally empty */
    }

    // Methods
    public static ContentorPool getInstance() {
        if (instance == null) {
            synchronized (ContentorPool.class) {
                if (instance == null) {
                    instance = new ContentorPool();
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

        MedicationContainer contentor = null;
        if (free.isEmpty() == true) {
            // No object available
            contentor = new MedicationContainer();
            contentor.setType(MedicationContainerType.CONTENTOR);
        } else {
            contentor = free.get(0);
            free.remove(0);
        }
        used.add(contentor);
        return contentor;
    }

    public synchronized void release(MedicationContainer contentor) throws ObjectNotFoundException {
        if (used.contains(contentor) == false) {
            throw new ObjectNotFoundException();
        }
        used.remove(contentor);
        free.add(contentor);
    }

    public synchronized void resetPool() {
        this.free.clear();
        this.used.clear();
    }

    public synchronized void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}