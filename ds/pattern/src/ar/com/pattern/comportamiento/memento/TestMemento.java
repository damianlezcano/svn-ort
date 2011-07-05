package ar.com.pattern.comportamiento.memento;
/*
 * Memento guarda parte o todo el estado interno de un objeto, para que este objeto pueda ser 
 * restaurado más tarde al estado guardado por Memento. Esta operación debe ocurrir sin romper 
 * el principio del encapsulamiento.
 */
public class TestMemento {
	
	public static void main(String[] args) {
		Conserje almacen = new Conserje();
		Originator originador = new Originator();
		
		originador.setEstado("State1");
		almacen.addMemento(originador.crearMemento());
		
		originador.setEstado("State2");
		almacen.addMemento(originador.crearMemento());
		
		originador.setEstado("State3");
		almacen.addMemento(originador.crearMemento());
		
		originador.setEstado("State4");
		almacen.addMemento(originador.crearMemento());
		
		originador.restaurarAlMemento(almacen.obtenerMemento(1));
		
		System.out.println("El estado es: " + originador.getEstado());
	}
}