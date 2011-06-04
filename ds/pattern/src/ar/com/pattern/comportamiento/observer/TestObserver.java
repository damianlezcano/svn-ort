package ar.com.pattern.comportamiento.observer;

public class TestObserver {
	
	public static void main(String[] args) {
		//Es el que va ser observado
		ConcreteSubject subjet = new ConcreteSubject();
		
		// observadores al sujecto
		ConcreteObserver observador1 = new ConcreteObserver(subjet, "pedro");
		ConcreteObserver observador2 = new ConcreteObserver(subjet, "maria");
		
		//subcribo a pedro a la publicacion
		subjet.attach(observador1);
		//subcribo a maria a la publicacion
		subjet.attach(observador2);
		
		// Change subject and notify observers
		subjet.setSubjectState("modificado");
		System.out.println("---");
		subjet.detach(observador1);
		subjet.setSubjectState("eliminado");
	}
}