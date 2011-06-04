package ar.com.pattern.comportamiento.memento;

public class Originator {
	private String state;

	/*
	 * lots of memory consumptive private data that is not necessary to define
	 * the state and should thus not be saved. Hence the small memento object.
	 */
	public void set(String state) {
		System.out.println("Originator: Setting state to " + state);
		this.state = state;
	}

	public String get(){
		return state;
	}
	
	/**
	 * CrearMemento()
	 */
	public Memento saveToMemento() {
		System.out.println("Originator: Saving to Memento.");
		return new Memento(state);
	}

	/**
	 * EstablecerMemento(Memento m)
	 */
	public void restoreFromMemento(Memento m) {
		state = m.getSavedState();
		System.out.println("Originator: State after restoring from Memento: " + state);
	}
}