package ar.com.pattern.comportamiento.state.tamagochi;

/*
 * PROPOSITO: Permite que un objeto modifique su comportamiento cada vez que cambie su estado interno. 
 * Parecera que cambia la clase del objeto
 */
public class TestUsuario {

	public static void main(String[] args) {
		Contexto contexto = new Contexto(new EstadoMuerto());
		contexto.comer();
		contexto.comer();
		contexto.comer();	
	}
}