package ar.com.pattern.comportamiento.observer;

/**
 * Clase de negocio
 */
public class ConcreteSubject extends Subject {

	//variacion porcentual de las acciones
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