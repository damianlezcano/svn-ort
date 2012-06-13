package model.sincronizador;


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
		System.out.print("Avisando a " + name + " sobre el nuevo estado, que paso de " + observerState + " a ");
		observerState = subject.getSubjectState();
		System.out.println(observerState);
	}
}