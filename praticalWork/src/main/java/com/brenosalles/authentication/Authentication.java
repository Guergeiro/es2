package com.brenosalles.authentication;

import java.util.concurrent.ConcurrentHashMap;

public class Authentication {
    // Attributes
    private static Authentication instance;
    private ConcurrentHashMap<String, String> users = new ConcurrentHashMap<String, String>();

    // Constructor
    private Authentication() {
        /** Intentionally empty */
    }

    // Methods
    public static Authentication getInstance() {
        if (instance == null) {
            synchronized (Authentication.class) {
                if (instance == null) {
                    instance = new Authentication();
                }
            }
        }
        return instance;
    }

    public Boolean signIn(String username, String password) {
        if (users.containsKey(username) == false) {
            return false;
        }

        return users.get(username).equals(password);
    }

    public Boolean signUp(String username, String password) {
        if (users.containsKey(username) == true) {
            return false;
        }

        users.put(username, password);

        return true;
    }

    public void resetUsers() {
        users.clear();
    }
}