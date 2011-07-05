package ar.com.pattern.comportamiento.state.libro;

/*
 * PROPOSITO: Permite que un objeto modifique su comportamiento cada vez que cambie su estado interno. Parecera que cambia la clase del objeto
 */
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
