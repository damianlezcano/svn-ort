package ar.com.pattern.comportamiento.memento;

import java.util.ArrayList;

/**
 * Es responsable de guardar en lugar seguro el memento.
 * Nunca examina los contenidos del memento, ni opera sobre ellos.
 */
public class Conserje {
	private ArrayList<Memento> listaDeMementos = new ArrayList<Memento>();

	public void addMemento(Memento m) {
		listaDeMementos.add(m);
	}

	public Memento obtenerMemento(int index) {
		return listaDeMementos.get(index);
	}
}
