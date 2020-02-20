package com.es2.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple Singleton.
 */
public class RegistryTest {
    Registry current = Registry.getInstance();

    @Test
    public void checkPath() {
        // Creates a sample path
        String testPath = "/this/is/a/path";

        // Sets a path
        current.setPath(testPath);

        assertEquals(testPath, current.getPath());
    }

    @Test
    public void checkConnectionString() {
        // Creates a sample path
        String testConnectionString = "https://this/is/a/connection/string.com";

        // Sets a path
        current.setConnectionString(testConnectionString);

        assertEquals(testConnectionString, current.getConnectionString());
    }
}
