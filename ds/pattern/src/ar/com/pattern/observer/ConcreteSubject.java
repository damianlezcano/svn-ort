package ar.com.pattern.observer;

public class ConcreteSubject extends Subject {

	private String subjectState;

	/**
	 * Establecer Estado
	 * @param subjectState
	 */
	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
		this.notificar();
	}

	/**
	 * Obtener estado
	 * @return
	 */
	public String getSubjectState() {
		return subjectState;
	}
}