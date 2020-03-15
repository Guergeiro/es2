package com.brenosalles.authentication;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {
    @Before
    public void resetUsers() {
        Authentication.getInstance().resetUsers();
    }

    @Test
    public void checkPrivateConstructor() throws NoSuchMethodException, SecurityException {
        assertTrue(Modifier.isPrivate(Authentication.class.getDeclaredConstructor().getModifiers()));
    }

    @Test
    public void checkStaticSingletonMethod() throws NoSuchMethodException, SecurityException {
        assertTrue(Modifier.isStatic(Authentication.class.getDeclaredMethod("getInstance").getModifiers()));
    }

    @Test
    public void checkStaticSingletonField() throws NoSuchFieldException, SecurityException {
        assertTrue(Modifier.isStatic(Authentication.class.getDeclaredField("instance").getModifiers()));
    }

    @Test
    public void testValidSignUp() {
        String username = "Breno";
        String password = "Breno";

        assertTrue(Authentication.getInstance().signUp(username, password));
    }

    @Test
    public void testInvalidSignUp() {
        String username = "Breno";
        String password = "Breno";
        Authentication.getInstance().signUp(username, password);
        assertFalse(Authentication.getInstance().signUp(username, password));
    }

    @Test
    public void testValidSignIn() {
        String username = "Breno";
        String password = "Breno";
        Authentication.getInstance().signUp(username, password);

        assertTrue(Authentication.getInstance().signIn(username, password));
    }

    @Test
    public void testInvalidUsernameSignIn() {
        String username = "Invalid";
        String password = "Breno";
        Authentication.getInstance().signUp("Breno", password);

        assertFalse(Authentication.getInstance().signIn(username, password));
    }

    @Test
    public void testInvalidPasswordSignIn() {
        String username = "Breno";
        String password = "Invalid";
        Authentication.getInstance().signUp(username, "Breno");

        assertFalse(Authentication.getInstance().signIn(username, password));
    }
}
