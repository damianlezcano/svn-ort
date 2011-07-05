package ar.com.pattern.comportamiento.command.calculadora;

/**
 * <b>PARTICIPANTE: Receptor</b> (Documento, Aplicacion)
 * <li> Sabe como llevar a cabo las operaciones asociadas a una peticion. Cualquier
 * clase puede hacer actuar como Receptor
 */
public class Calculadora {
	
	private Integer result = 0;
	
	public Calculadora() {
	}

	public void sumar() {
		result++;
		System.out.println("Calculadora: Ejecuto metodo 'sumar()' y el resultado es: " + result);
	}

	public void restar() {
		result--;
		System.out.println("Calculadora: Ejecuto metodo 'restar()' y el resultado es: " + result);
	}
}
