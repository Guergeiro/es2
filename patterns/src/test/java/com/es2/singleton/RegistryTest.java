package com.es2.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.Test;

public class RegistryTest {

    @Test
    public void checkPrivateConstructor() throws NoSuchMethodException, SecurityException {
        assertTrue(Modifier.isPrivate(Registry.class.getDeclaredConstructor().getModifiers()));
    }

    @Test
    public void checkStaticSingletonMethod() throws NoSuchMethodException, SecurityException {
        assertTrue(Modifier.isStatic(Registry.class.getDeclaredMethod("getInstance").getModifiers()));
    }

    @Test
    public void checkStaticSingletonField() throws NoSuchFieldException, SecurityException {
        assertTrue(Modifier.isStatic(Registry.class.getDeclaredField("instance").getModifiers()));
    }

    @Test
    public void checkPath() {
        // Creates a sample path
        String testPath = "/this/is/a/path";

        // Sets a path
        Registry.getInstance().setPath(testPath);

        assertEquals(testPath, Registry.getInstance().getPath());
    }

    @Test
    public void checkConnectionString() {
        // Creates a sample path
        String testConnectionString = "https://this/is/a/connection/string.com";

        // Sets a path
        Registry.getInstance().setConnectionString(testConnectionString);

        assertEquals(testConnectionString, Registry.getInstance().getConnectionString());
    }
}
