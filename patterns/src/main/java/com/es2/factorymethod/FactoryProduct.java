package com.es2.factorymethod;

public abstract class FactoryProduct {

    public static Product makeProduct(String type) throws UndefinedProductException {
        switch (type.toLowerCase()) {
            case "software":
                return new Software();
            case "computer":
                return new Computer();
            default:
                throw new UndefinedProductException();
        }
    }
}