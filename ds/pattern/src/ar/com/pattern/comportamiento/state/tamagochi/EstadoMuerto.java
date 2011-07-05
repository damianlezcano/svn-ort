package ar.com.pattern.comportamiento.state.tamagochi;

/**
 * Cada subclase implementa el comportamiento asociado con un estado del contexto.
 */
public class EstadoMuerto implements Estado {

	@Override
	public Estado comer() {
		System.out.println("Muerto: No le puedo dar de comer por que esta muerto");
		return new EstadoMuerto();
	}

	@Override
	public Estado insultar() {
		System.out.println("Muerto: No le puedo insultar por que esta muerto");
		return new EstadoMuerto();
	}

	@Override
	public Estado patear() {
		System.out.println("Muerto: No le puedo patear por que esta muerto");
		return new EstadoMuerto();
	}
}