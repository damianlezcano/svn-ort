package ar.com.pattern.creacional.factory.method;

//Definimos la clase abstracta constructora
public abstract class Creator {
	
	// Operación que realiza
	public Product anOperation() {
		return factoryMethod();
	}

	// Definimos método abstracto
	protected abstract Product factoryMethod();
}