package ar.com.pattern.comportamiento.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Conoce a sus observadores. Un sujeto puede ser observado por cualquier numero de objetos 'Observador'
 */
abstract class Subject {
	
	private List<Observer> observers =new ArrayList<Observer>();
	
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	public void detach(Observer observer){
		observers.remove(observer);
	}
	
	public void notificar(){
		for (Observer obs : observers) {
			obs.update();
		}
	}
}