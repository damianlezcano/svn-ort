package ar.com.pattern.creacional.factory.method.libro;

public class TestFactory {
	public static void main(String args[]) {
		Creator factory = new ConcreteCreator();
		Producto producto = factory.unaOperacion();
		producto.mostrar();
	}
}
