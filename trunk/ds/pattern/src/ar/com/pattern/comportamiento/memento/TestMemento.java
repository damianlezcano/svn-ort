package ar.com.pattern.comportamiento.memento;

public class TestMemento {
	
	public static void main(String[] args) {
		Conserje conserje = new Conserje();
		Originator originador = new Originator();
		
		originador.set("State1");
		conserje.addMemento(originador.saveToMemento());
		
		originador.set("State2");
		conserje.addMemento(originador.saveToMemento());
		
		originador.set("State3");
		conserje.addMemento(originador.saveToMemento());
		
		originador.set("State4");
		conserje.addMemento(originador.saveToMemento());
		
		originador.restoreFromMemento(conserje.getMemento(1));
		
		System.out.println("El estado es: " + originador.get());
	}
}