package com.brenosalles.es2;

public class Registry {
    // Attributes
    private static Registry instance = new Registry();
    private String connectionString;
    private String path;

    // Constructor
    private Registry() {
    };

    // Getters & Setters
    public static Registry getInstance() {
        return instance;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}