package ar.com.pattern.estructural.composite.mcdonal;

abstract class Item {
	
	protected String nombre;

	public Item(String nombre) {
		this.nombre = nombre;
	}

	abstract public void anadir(Item c);

	abstract public void eliminar(Item c);

	abstract public void obtenerHijo(int hijo);
	
	abstract public void operacion();
	
	abstract public int calcularPrecio();
}
