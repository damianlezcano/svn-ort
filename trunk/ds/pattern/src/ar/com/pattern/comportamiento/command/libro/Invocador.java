package ar.com.pattern.comportamiento.command.libro;

/**
 * PARTICIPANTE: Invocador o Invoker (ElementoDeMenu)
 * <li> Le pide a la orden que ejecute la peticion
 */
public class Invocador {
	
	private Orden ordenA;
	private Orden ordenB;

	public Invocador(Orden ordenA, Orden ordenB) {
		System.out.println("Invocador: (constructor) Inicializo la 'ordenA'");
		this.ordenA = ordenA;
		System.out.println("Invocador: (constructor) Inicializo la 'ordenB'");
		this.ordenB = ordenB;
	}

	/**
	 * Esta pude ser sumar por ejemplo
	 */
	public void ordenA() {
		System.out.println("Invocador: Ejecuto metodo 'ordenA()'");
		ordenA.execute();
	}

	/**
	 * Esta pude ser restar por ejemplo
	 */
	public void ordenB() {
		System.out.println("Invocador: Ejecuto metodo 'ordenB()'");
		ordenB.execute();
	}
}
