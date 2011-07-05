package ar.com.pattern.estructural.facade;

/*
 * El patr�n fachada estructura un entorno de programaci�n y reduce complejidad con la divisi�n en subsistemas.
 * Proporciona una interfaz unificada a un conjunto de interfaces en un subsistema. 
 * Define una interfaz de alto nivel que hace al subsistema m�s f�cil de usar.
 */
public class TestCliente {
	public static void main(String args[]) {
		Fachada fachada = new Fachada();
		fachada.buscarLibros();
		fachada.buscarVideo();
		fachada.buscarMusica();
	}
}
