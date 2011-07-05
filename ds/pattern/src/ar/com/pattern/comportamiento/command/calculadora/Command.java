package ar.com.pattern.comportamiento.command.calculadora;

/**
 * PARTICIPANTE: Orden o Command
 * <li> Declara una interfaz para ejecutar una operacion
 */
interface Command {
	public void execute();
	public String nombreComando();
}
