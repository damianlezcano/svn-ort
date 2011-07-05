package ar.com.pattern.creacional.factory.method.libro;

//Definimos la clase abstracta constructora
public abstract class Creator {
	
	@SuppressWarnings("unused")
	private Producto producto;
	
	// Operación que realiza
	public Producto unaOperacion() {
		return metodoDeFabricacion();
	}

	// Definimos método abstracto
	protected abstract Producto metodoDeFabricacion();
}