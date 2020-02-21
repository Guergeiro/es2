package com.es2.objectpool;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReusablePoolTest {
    private static ReusablePool pool;

    @BeforeClass
    public static void beforeClass() {
        pool = ReusablePool.getInstance();
    }

    @Before
    public void suitUp() {
        pool.resetPool();
    }

    @After
    public void tearDown() {
        pool.resetPool();
    }

    @Test
    public void testNullReusablePool() {
        assertFalse("ReusablePool is null!", pool == null);
    }

    @Test(expected = PoolExhaustedException.class)
    public void testSetMaximumConnections() throws PoolExhaustedException, IOException {
        Integer maxConnections = (int) (Math.random() * 20 + 1);
        pool.setMaxPoolSize(maxConnections);

        HttpURLConnection conn = null;
        for (Integer i = 0; i < maxConnections; i++) {
            conn = pool.acquire();
            assertFalse("Max connections could not be set properly!", conn == null);
            conn = null;
        }
        conn = pool.acquire();
        assertTrue("Max connections could not be set properly!", conn == null);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void testObjectNullNotFound() throws ObjectNotFoundException {
        HttpURLConnection conn = null;
        pool.release(conn);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void testObjectNotFound() throws ObjectNotFoundException, PoolExhaustedException, IOException {
        HttpURLConnection conn = pool.acquire();
        assertFalse("Connection is not returning!", conn == null);
        pool.release(conn);
        pool.release(conn);
    }
}
