package ar.com.pattern.creacional.factory.method.libro;

public class ConcreteCreator extends Creator {
	
	protected Producto metodoDeFabricacion() {
		return new ConcreteProduct();
	}
	
}