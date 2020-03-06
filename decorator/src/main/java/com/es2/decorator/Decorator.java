package com.es2.decorator;

import java.io.IOException;

public class Decorator implements AuthInterface {
    // Attributes
    private AuthInterface auth;

    // Constructor
    public Decorator(AuthInterface auth) {
        this.auth = auth;
    }

    @Override
    public void auth(String username, String password) throws AuthException, IOException {
        auth.auth(username, password);
    }
}