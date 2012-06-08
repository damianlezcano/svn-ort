package model;



/**
 * Correr
 */
public class Run extends Activity {

	/**
	 * Tiempo en segundos en que se realizo la tarea
	 */
	private Float time;
	
	/**
	 * Distancia recorrida
	 */
	private Float distance;

	/**
	 * Este calulo se realiza de la siguinte manera:
	 * <p><b>distancia / tiempo</b></p>
	 */
	@Override
	public Float calculate() {
		return distance / time;
	} 
	
	public void prueba(){
		
	}
	
}
