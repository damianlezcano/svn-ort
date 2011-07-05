package ar.com.pattern.comportamiento.state.tamagochi;

/**
 * Cada subclase implementa el comportamiento asociado con un estado del contexto.
 */
public class EstadoContento implements Estado {

	@Override
	public Estado comer() {
		System.out.println("Contento: Se pone triste cuando come");
		return new EstadoTriste();
	}

	@Override
	public Estado insultar() {
		System.out.println("Contento: Se pone triste cuando lo insultan");
		return new EstadoTriste();
	}

	@Override
	public Estado patear() {
		System.out.println("Contento: Se muere cuando lo patean");
		return new EstadoMuerto();
	}
}