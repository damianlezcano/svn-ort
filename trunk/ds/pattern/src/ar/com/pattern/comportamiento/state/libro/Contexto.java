package ar.com.pattern.comportamiento.state.libro;

public class Contexto {
	private Estado state;

	public void setState(Estado state) {
		this.state = state;
	}

	public Estado getState() {
		return state;
	}

	public void request() {
		state.manejar();
	}
}
