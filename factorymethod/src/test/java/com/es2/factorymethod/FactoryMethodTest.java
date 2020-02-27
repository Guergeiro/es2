package com.es2.factorymethod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FactoryMethodTest {
    @Test
    public void testComputerCreate() throws UndefinedProductException {
        Product computer = FactoryProduct.makeProduct("computer");
        assertEquals(Computer.class.getSimpleName(), computer.getClass().getSimpleName());
    }

    @Test
    public void testSoftwareCreate() throws UndefinedProductException {
        Product software = FactoryProduct.makeProduct("software");
        assertEquals(Software.class.getSimpleName(), software.getClass().getSimpleName());
    }

    @Test(expected = UndefinedProductException.class)
    public void testWrongTypeCreate() throws UndefinedProductException {
        Product wrongType = FactoryProduct.makeProduct("wrongtype");
    }
}
