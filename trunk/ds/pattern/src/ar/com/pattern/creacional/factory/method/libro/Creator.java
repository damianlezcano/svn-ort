package ar.com.pattern.creacional.factory.method.libro;

//Definimos la clase abstracta constructora
public abstract class Creator {
	
	// Operaci�n que realiza
	public Product anOperation() {
		return factoryMethod();
	}

	// Definimos m�todo abstracto
	protected abstract Product factoryMethod();
}