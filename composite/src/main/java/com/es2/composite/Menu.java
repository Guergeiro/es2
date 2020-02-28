package com.es2.composite;

public abstract class Menu {
    // Attributes
    private String label;

    // Methods
    public abstract void showOptions();

    // Getters & Setters
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
