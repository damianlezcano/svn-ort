package ar.com.pattern.comportamiento.state.libro;

public class TestState {
	public static void main(String arg[]) {
		try {
			Estado state = new EstadoConcretoA();
			Contexto context = new Contexto();
			context.setState(state);
			context.request();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
