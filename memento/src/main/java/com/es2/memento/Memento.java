package com.es2.memento;

import java.util.ArrayList;

public class Memento {
    // Attributes
    private ArrayList<String> state = new ArrayList<String>();

    // Constructor
    public Memento(ArrayList<String> state) {
        this.state = new ArrayList<String>(state);
    }

    // Getters and Setters
    public ArrayList<String> getState() {
        return state;
    }

    public void setState(ArrayList<String> state) {
        this.state = state;
    }
}