package com.es2.composite;

public class Link extends Menu {
    // Attributes
    private String URL;

    // Methods
    @Override
    public void showOptions() {
        System.out.println(this.getLabel());
        System.out.println(URL);
    }

    // Getters & Setters
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}