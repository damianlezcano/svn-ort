package ar.com.pattern.estructural.composite.mcdonal;

import java.util.ArrayList;

class Combo extends Item {
	
	/**
	 * Esto es equivalente a los combos de mac donals
	 */
	private ArrayList<Item> hijo = new ArrayList<Item>();

	public Combo(String name) {
		super(name);
	}

	@Override
	public void anadir(Item componente) {
		System.out.println("Añadir " + componente.nombre.toUpperCase() + " al " + nombre.toUpperCase());
		hijo.add(componente);
	}

	@Override
	public void eliminar(Item componente) {
		System.out.println("Eliminar " + componente.nombre.toUpperCase() + " al " + nombre.toUpperCase());
		hijo.remove(componente);
	}

	@Override
	public void obtenerHijo(int profundidad) {
		System.out.println("Obtener " + nombre.toUpperCase() + " en la factura");
	}

	@Override
	public void operacion() {
		System.out.println("Ejecuta operacion" + nombre.toUpperCase());
	}

	@Override
	public int calcularPrecio() {
		int suma = 0;
		for (Item item : hijo) {
			suma+=item.calcularPrecio();
		}
		return (suma * 2);
	}
}
