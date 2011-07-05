package ar.com.pattern.estructural.composite.libro;

import java.util.ArrayList;

class Compuesto extends Componente {
	
	/**
	 * Esto es equivalente a los combos de mac donals
	 */
	private ArrayList<Componente> hijo = new ArrayList<Componente>();

	public Compuesto(String name) {
		super(name);
	}

	@Override
	public void Anadir(Componente componente) {
		System.out.println("Añadir componente " + componente.nombre.toUpperCase() + " (compuesto / hoja) al componente " + nombre.toUpperCase());
		hijo.add(componente);
	}

	@Override
	public void Eliminar(Componente componente) {
		System.out.println("Eliminar componente " + componente.nombre.toUpperCase() + " (compuesto / hoja) del componente " + nombre.toUpperCase());
		hijo.remove(componente);
	}

	@Override
	public void ObtenerHijo(int profundidad) {
		System.out.println("Obtener Hoja del componente " + nombre.toUpperCase() + " (compuesto / hoja)");
	}

	@Override
	public void Operacion() {
		System.out.println("Operacion del compoonente" + nombre.toUpperCase());
	}
}
