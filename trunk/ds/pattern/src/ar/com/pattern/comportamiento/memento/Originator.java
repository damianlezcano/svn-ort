package ar.com.pattern.comportamiento.memento;

/**
 * <li>Crea un objeto Memento conteniendo una fotografía (un instante) de su
 * estado interno. <li>Usa a Memento para restaurar su estado interno.
 */
public class Originator {
	
	private String state;
	
	/**
	 * CrearMemento()
	 */
	public Memento crearMemento() {
		Memento memento = new Memento();
		memento.setState(state);
		return memento;
	}

	/**
	 * EstablecerMemento(Memento m)
	 */
	public void restaurarAlMemento(Memento m) {
		System.out.println("Originator: State after restoring from Memento: " + state);
		state = m.getState();
	}
	
	//*******************************************************************

	public void setEstado(String state){
		this.state = state;
	}
	
	public String getEstado(){
		return state;
	}
}