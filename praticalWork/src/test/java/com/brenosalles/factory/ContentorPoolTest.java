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

package com.brenosalles.factory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import com.brenosalles.medication.MedicationContainer;

import org.junit.After;
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