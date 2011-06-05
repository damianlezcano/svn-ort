package ar.com.pattern.creacional.factory.method.libro;

public class TestFactory {
	public static void main(String args[]) {
		Creator aCreator;
		aCreator = new ConcreteCreator();
		Product producto = aCreator.anOperation();
		producto.operacion();
	}
}
