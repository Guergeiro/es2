package com.es2.decorator;

import java.io.IOException;

import org.junit.Test;

public class DecoratorTest {
    // Está tudo correto
    @Test
    public void testRightAuthWithoutDecorators() throws AuthException, IOException {
        AuthInterface auth = new Auth();
        auth.auth("admin", "admin");
    }

    // Password errada
    @Test(expected = AuthException.class)
    public void testWrongAuthWithoutDecorators() throws AuthException, IOException {
        AuthInterface auth = new Auth();
        auth.auth("admin", "notadmin");
    }

    // Auth Correta, mas admin é uma palavra comum
    @Test(expected = AuthException.class)
    public void testRightAuthWithCommonWordsDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Auth());
        auth.auth("admin", "admin");
    }

    // Auth incorreta, mas palavra não é comum
    @Test(expected = AuthException.class)
    public void testWrongAuthWithCommonWordsDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Auth());
        auth.auth("admin", "ola");
    }

    // Auth correta com logging decorator
    @Test
    public void testRightAuthWithLoggingDecorator() throws AuthException, IOException {
        AuthInterface auth = new Logging(new Auth());
        auth.auth("admin", "admin");
    }

    // Auth incorreta com logging decorator
    @Test(expected = AuthException.class)
    public void testWrongAuthWithLoggingDecorator() throws AuthException, IOException {
        AuthInterface auth = new Logging(new Auth());
        auth.auth("admin", "notadmin");
    }

    // Auth correta, com todos decorators. Dá error porque admin é uma palavra comum
    @Test(expected = AuthException.class)
    public void testRightAuthWithAllDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Logging(new Auth()));
        auth.auth("admin", "admin");
    }

    // Auth incorreta, mas com palavra não comum
    @Test(expected = AuthException.class)
    public void testWrongAuthWithAllDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Logging(new Auth()));
        auth.auth("admin", "ola");
    }
}
