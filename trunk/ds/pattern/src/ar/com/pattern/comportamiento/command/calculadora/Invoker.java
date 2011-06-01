package ar.com.pattern.comportamiento.command.calculadora;

/**
 * PARTICIPANTE: Invocador o Invoker (ElementoDeMenu)
 * <li> Le pide a la orden que ejecute la peticion
 */
public class Invoker {
	private Command sumarCommand;
	private Command restarCommand;

	public Invoker(Command flipUpCmd, Command flipDownCmd) {
		this.sumarCommand = flipUpCmd;
		this.restarCommand = flipDownCmd;
	}

	public void sumarGenerico() {
		sumarCommand.execute();
	}

	public void restarGenerico() {
		restarCommand.execute();
	}
}
