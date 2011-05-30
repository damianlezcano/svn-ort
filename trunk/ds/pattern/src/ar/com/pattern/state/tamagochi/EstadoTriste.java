package ar.com.pattern.state.tamagochi;

public class EstadoTriste implements Estado {

	@Override
	public Estado comer() {
		System.out.println("Triste: Se pone contento cuando come");
		return new EstadoMuerto();
	}

	@Override
	public Estado insultar() {
		System.out.println("Triste: Se pone triste cuando lo insultan");
		return new EstadoTriste();
	}

	@Override
	public Estado patear() {
		System.out.println("Triste: Se muere cuando lo patean");
		return new EstadoMuerto();
	}
}