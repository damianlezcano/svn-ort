package ar.com.pattern.comportamiento.command.libro;

/**
 * PARTICIPANTE: OrdenConcreta (OrdenPegar, OrdenAbrir) 
 * <li>Define un enlace entre un objeto Receptor y una accion 
 * <li>Implementa Ejecutar invocando la correspondiente operacion u operaciones del Receptor.
 */
public class OrdenConcretaB implements Orden {
	private Receptor receptor;

	public OrdenConcretaB(Receptor receptor) {
		System.out.println("OrdenConcretaB: (constructor) Inicializo el 'receptor' con el enviado por parametro");
		this.receptor = receptor;
	}

	public void execute() {
		System.out.println("OrdenConcretaB: Ejecuto el metodo 'execute()'");
		receptor.accion();
	}
}
