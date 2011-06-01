package ar.com.pattern.state;

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
