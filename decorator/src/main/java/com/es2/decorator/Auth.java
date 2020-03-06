package com.es2.decorator;

import java.io.IOException;

public class Auth implements AuthInterface {
    @Override
    public void auth(String username, String password) throws AuthException, IOException {
        if ("admin".equals(username) == false) {
            throw new AuthException();
        }

        if ("admin".equals(password) == false) {
            throw new AuthException();
        }
    }
}
