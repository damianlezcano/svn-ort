package ar.com.pattern.singleton;

/* 
 * Proposito:
 * Garantiza que en clase solo tenga una instancia y proporciona un puntero de acceso global a ella. 
 * 
 * Motivacion:
 * 
 * Colaboracion:
 * 
 */
public class TestSingleton {
	public static void main(String arg[]) {
		
		Singleton ss = Singleton.getInstancia(); // creacion de la primera instancia

		Singleton aa = Singleton.getInstancia(); // intento de creacion de la segunda instancia

		Singleton bb = Singleton.getInstancia(); // intento de creacion de la tercera instancia
	}
}
