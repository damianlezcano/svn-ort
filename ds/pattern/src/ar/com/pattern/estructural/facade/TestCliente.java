package ar.com.pattern.estructural.facade;

/*
 * El patrón fachada estructura un entorno de programación y reduce complejidad con la división en subsistemas.
 * Proporciona una interfaz unificada a un conjunto de interfaces en un subsistema. 
 * Define una interfaz de alto nivel que hace al subsistema más fácil de usar.
 */
public class TestCliente {
	public static void main(String args[]) {
		Fachada fachada = new Fachada();
		fachada.buscarLibros();
		fachada.buscarVideo();
		fachada.buscarMusica();
	}
}
