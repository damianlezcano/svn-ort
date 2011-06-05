package ar.com.pattern.creacional.factory.method.libro;

public class ConcreteCreator extends Creator {
    protected Product factoryMethod() {
        return new ConcreteProduct();
    }
}