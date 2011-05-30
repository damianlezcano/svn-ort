package ar.com.pattern.command;

/* The Invoker class */
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
