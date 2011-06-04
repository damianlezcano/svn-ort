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
		System.out.println("Invoker: Ejecuto metodo 'sumarGenerico()'");
		sumarCommand.execute();
	}

	public void restarGenerico() {
		System.out.println("Invoker: Ejecuto metodo 'restarGenerico()'");
		restarCommand.execute();
	}
}
