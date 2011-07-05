package ar.com.pattern.comportamiento.state.tamagochi;

/**
 * Define interfaz y mantiene una instancia con el estado actual
 */
public class Contexto {
	private Estado state;

	Contexto(Estado estado){
		state = estado;
	}
	
	public void setState(Estado state) {
		this.state = state;
	}

	public Estado getState() {
		return state;
	}

	public void comer(){
		state = state.comer();
	}
	
	public void insultar(){
		state = state.insultar();
	}
	
	public void patear(){
		state = state.patear();
	}
}
