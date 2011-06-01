package ar.com.pattern.comportamiento.command.libro;

/**
 * PARTICIPANTE: OrdenConcreta (OrdenPegar, OrdenAbrir) 
 * <li>Define un enlace entre un objeto Receptor y una accion 
 * <li>Implementa Ejecutar invocando la correspondiente operacion u operaciones del Receptor.
 */
public class OrdenConcretaA implements Orden {
	private Receptor receptor;

	public OrdenConcretaA(Receptor receptor) {
		System.out.println("OrdenConcretaA: (constructor) Inicializo el 'receptor' con el enviado por parametro");
		this.receptor = receptor;
	}

	public void execute() {
		System.out.println("OrdenConcretaA: Ejecuto el metodo 'execute()'");
		receptor.accion();
	}
}
