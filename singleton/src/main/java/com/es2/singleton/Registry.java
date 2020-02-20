package com.es2.singleton;

public class Registry {
    // Attributes
    private static Registry instance;
    private String connectionString;
    private String path;

    // Constructor
    private Registry() {
    };

    // Getters & Setters
    public static Registry getInstance() {
        if (instance == null) {
            instance = new Registry();
        }
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