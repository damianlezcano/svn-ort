package ar.com.pattern.creacional.factory.method.libro;

public class ConcreteProduct implements Producto {

	@Override
	public void mostrar() {
		System.out.println("Producto creado");
	}
}
