package com.brenosalles.factory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import com.brenosalles.medication.MedicationContainer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CaixaPoolTest {
    @Before
    public void beforeEachTest() {
        CaixaPool.getInstance().resetPool();
    }

    @After
    public void afterEachTest() {
        CaixaPool.getInstance().resetPool();
    }

    @Test
    public void checkPrivateConstructor() throws NoSuchMethodException, SecurityException {
        assertTrue(Modifier.isPrivate(CaixaPool.class.getDeclaredConstructor().getModifiers()));
    }

    @Test
    public void checkStaticSingletonMethod() throws NoSuchMethodException, SecurityException {
        assertTrue(Modifier.isStatic(CaixaPool.class.getDeclaredMethod("getInstance").getModifiers()));
    }

    @Test
    public void checkStaticSingletonField() throws NoSuchFieldException, SecurityException {
        assertTrue(Modifier.isStatic(CaixaPool.class.getDeclaredField("instance").getModifiers()));
    }

    @Test(expected = PoolExhaustedException.class)
    public void testSetMaximumConnections() throws PoolExhaustedException {
        CaixaPool pool = CaixaPool.getInstance();

        Integer maxConnections = (int) (Math.random() * 20 + 1);
        pool.setMaxSize(maxConnections);

        MedicationContainer caixa = null;
        for (Integer i = 0; i < maxConnections; i++) {
            caixa = pool.acquire();
            assertFalse("Max connections could not be set properly!", caixa == null);
            caixa = null;
        }

        caixa = pool.acquire();
        assertTrue("Max connections could not be set properly!", caixa == null);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void testObjectNullNotFound() throws ObjectNotFoundException {
        CaixaPool pool = CaixaPool.getInstance();

        MedicationContainer caixa = null;
        pool.release(caixa);
    }
}