package ar.com.pattern.comportamiento.command.calculadora;

import java.util.ArrayList;
import java.util.List;

/**
 * PARTICIPANTE: Invocador o Invoker (ElementoDeMenu)
 * <li> Le pide a la orden que ejecute la peticion
 */
public class Invoker {
	
	private Command sumarCommand;
	private Command restarCommand;
	
	private List<Command> listaDeComandosEjecutados = new ArrayList<Command>();

	public Invoker(Command sumarCommand, Command resarCommand) {
		this.sumarCommand = sumarCommand;
		this.restarCommand = resarCommand;
	}

	public void sumarGenerico() {
		System.out.println("Invoker: Ejecuto metodo 'sumarGenerico()'");
		sumarCommand.execute();
		listaDeComandosEjecutados.add(sumarCommand);
	}

	public void restarGenerico() {
		System.out.println("Invoker: Ejecuto metodo 'restarGenerico()'");
		restarCommand.execute();
		listaDeComandosEjecutados.add(restarCommand);
	}
	
	public void mostrarComandosEjecutados(){
		String comandos = "Se ejecuto el/los comando/s: ";;
		for (Command comando : listaDeComandosEjecutados) {
			comandos+= comando.nombreComando() + ", ";
		}
		System.out.println(comandos);
	}
}
