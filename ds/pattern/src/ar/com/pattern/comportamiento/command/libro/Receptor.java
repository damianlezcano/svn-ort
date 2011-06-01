package ar.com.pattern.comportamiento.command.libro;

/**
 * <b>PARTICIPANTE: Receptor</b> (Documento, Aplicacion)
 * <li> Sabe como llevar a cabo las operaciones asociadas a una peticion. Cualquier
 * clase puede hacer actuar como Receptor
 */
public class Receptor {
	
	public void accion() {
		System.out.println("Receptor: Se ejecuta la accion");
	}
}
