package ar.com.pattern.observer;


public class ConcreteObserver implements Observer {

	private String name;
	private String observerState;
	private ConcreteSubject subject;
	
	/**
	 * Mantiene una referencia a un SujetoConcreto
	 */
    public ConcreteObserver(ConcreteSubject subject, String name){
        this.subject = subject;
        this.name = name;
    }
	
	@Override
	public void update() {
		observerState = subject.getSubjectState();
		System.out.println("Observer " + name + "s new state is " + observerState);
	}
}