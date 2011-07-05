package ar.com.pattern.comportamiento.state.tamagochi;

/**
 * Define interfaz para el comportamiento asociado a un determinado estado del Contexto.
 */
interface Estado {
	public Estado comer();
	public Estado insultar();
	public Estado patear();
}