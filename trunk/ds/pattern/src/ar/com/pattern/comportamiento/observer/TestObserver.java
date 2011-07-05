package ar.com.pattern.comportamiento.observer;

/*
 * Definir una dependencia de uno-a-muchos entre objetos, de manera que 
 * cuando un objeto cambia de estado todos los que dependan de él sean 
 * notificados y actualizados automáticamente.
 */
public class TestObserver {
	
	public static void main(String[] args) {
		//Es el que va ser observado
		ConcreteSubject subjet = new ConcreteSubject();
		
		// observadores al sujecto
		Observer observador1 = new ConcreteObserver(subjet, "pedro");
		Observer observador2 = new ConcreteObserver(subjet, "maria");
		
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