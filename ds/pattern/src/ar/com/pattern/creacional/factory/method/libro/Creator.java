package ar.com.pattern.creacional.factory.method.libro;

//Definimos la clase abstracta constructora
public abstract class Creator {
	
	@SuppressWarnings("unused")
	private Producto producto;
	
	// Operaci�n que realiza
	public Producto unaOperacion() {
		return metodoDeFabricacion();
	}

	// Definimos m�todo abstracto
	protected abstract Producto metodoDeFabricacion();
}