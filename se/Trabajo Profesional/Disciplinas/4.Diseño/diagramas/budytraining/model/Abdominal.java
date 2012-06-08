package model;


/**
 * Abdominales
 */
public class Abdominal extends Activity {
	
	/**
	 * Tiempo en segundos en que se realizo la tarea
	 */
	private Float time;
	
	/**
	 * Repeticiones a realizar
	 */
	private Integer repetitions;

	//--------------------------

	/**
	 * Constructor de copia
	 */
	public Abdominal(Abdominal clone){
		super();
		this.repetitions = clone.repetitions;
	}
	
	public Abdominal(Integer repetitions) {
		super();
		this.repetitions = repetitions;
	}

	/**
	 * Este calulo se realiza de la siguinte manera:
	 * <p><b>repeticion / tiempo</b></p>
	 */
	@Override
	public Float calculate() {
		return repetitions / time;
	}
	
	//----
	public Float getTime() {
		return time;
	}

	public void setTime(Float time) {
		this.time = time;
	}

	public Integer getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(Integer repetitions) {
		this.repetitions = repetitions;
	}

}
