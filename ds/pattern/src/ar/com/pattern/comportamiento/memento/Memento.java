package ar.com.pattern.comportamiento.memento;

/**
 * <li> Guarda el estado interno del objeto Creador. El memento puede guardar tanta informacion del estado interno del
 * creador como sea necesario a discrecion del creador.
 * <li> Protege frente a accesos de otros objetos que no sean el creador.
 */
public class Memento {
	private String state;

	public void setState(String state){
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
}
