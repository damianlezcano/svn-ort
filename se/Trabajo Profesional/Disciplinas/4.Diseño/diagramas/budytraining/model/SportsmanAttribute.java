package model;

import java.util.List;

public class SportsmanAttribute {

	private float weight;
	private float power;
	
	//Frecuencia cardiaca en reposo.
	private int rcf;
	
	private float distance;
	private float time;
	private List<Muscles> muscles;
	
	/**
	 * Indice de masa corporal
	 */
	public float getBMI(){
		return 0f;
	}
	
}
