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
	
	private float speed;
	
	/**
	 * Indice de masa corporal
	 */
	public float getBMI(){
		return 0f;
	}

	//----
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getPower() {
		return power;
	}

	public void setPower(float power) {
		this.power = power;
	}

	public int getRcf() {
		return rcf;
	}

	public void setRcf(int rcf) {
		this.rcf = rcf;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public List<Muscles> getMuscles() {
		return muscles;
	}

	public void setMuscles(List<Muscles> muscles) {
		this.muscles = muscles;
	}
	
}
