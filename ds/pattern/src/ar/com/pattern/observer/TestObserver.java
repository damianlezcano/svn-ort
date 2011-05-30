package ar.com.pattern.observer;

public class TestObserver {
	
	public static void main(String[] args) {
		ConcreteSubject cs = new ConcreteSubject();
		cs.attach(new ConcreteObserver(cs, "X"));
		cs.attach(new ConcreteObserver(cs, "Y"));
		cs.attach(new ConcreteObserver(cs, "Z"));
		
		// Change subject and notify observers
		cs.setSubjectState("ABC");
		cs.setSubjectState("AB2");
		cs.setSubjectState("AB3");
//		cs.notificar();
	}
}