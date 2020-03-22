/*
 * MIT License
 * 
 * Copyright (c) 2020 Breno Salles
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.brenosalles.authentication;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author <a href="https://brenosalles.com" target="_blank">Breno</a>
 *
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
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
