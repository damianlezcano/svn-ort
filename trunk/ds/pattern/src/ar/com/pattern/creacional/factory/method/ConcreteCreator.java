package ar.com.pattern.creacional.factory.method;

public class ConcreteCreator extends Creator {
    protected Product factoryMethod() {
        return new ConcreteProduct();
    }
}