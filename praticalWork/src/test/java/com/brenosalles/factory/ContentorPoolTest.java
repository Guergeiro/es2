package com.brenosalles.factory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import com.brenosalles.medication.MedicationContainer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContentorPoolTest {
    @Before
    public void beforeEachTest() {
        ContentorPool.getInstance().resetPool();
    }

    @After
    public void afterEachTest() {
        ContentorPool.getInstance().resetPool();
    }

    @Test
    public void checkPrivateConstructor() throws NoSuchMethodException, SecurityException {
        assertTrue(Modifier.isPrivate(ContentorPool.class.getDeclaredConstructor().getModifiers()));
    }

    @Test
    public void checkStaticSingletonMethod() throws NoSuchMethodException, SecurityException {
        assertTrue(Modifier.isStatic(ContentorPool.class.getDeclaredMethod("getInstance").getModifiers()));
    }

    @Test
    public void checkStaticSingletonField() throws NoSuchFieldException, SecurityException {
        assertTrue(Modifier.isStatic(ContentorPool.class.getDeclaredField("instance").getModifiers()));
    }

    @Test(expected = PoolExhaustedException.class)
    public void testSetMaximumConnections() throws PoolExhaustedException {
        ContentorPool pool = ContentorPool.getInstance();

        Integer maxConnections = (int) (Math.random() * 20 + 1);
        pool.setMaxSize(maxConnections);

        MedicationContainer contentor = null;
        for (Integer i = 0; i < maxConnections; i++) {
            contentor = pool.acquire();
            assertFalse("Max connections could not be set properly!", contentor == null);
            contentor = null;
        }

        contentor = pool.acquire();
        assertTrue("Max connections could not be set properly!", contentor == null);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void testObjectNullNotFound() throws ObjectNotFoundException {
        ContentorPool pool = ContentorPool.getInstance();

        MedicationContainer contentor = null;
        pool.release(contentor);
    }
}