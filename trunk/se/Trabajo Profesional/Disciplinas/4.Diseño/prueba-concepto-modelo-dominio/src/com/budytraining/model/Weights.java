package com.budytraining.model;

/**
 * Pesas
 */
public class Weights extends Activity {

	/**
	 * Repeticiones a realizar
	 */
	private Integer repetitions;

	/**
	 * Peso
	 */
	private Float weight;
	
	/**
	 * Este calulo se realiza de la siguinte manera:
	 * <p><b>timpo(tiempo / repeticion)</b></p>
	 */
	@Override
	public Float calculate() {
		return null;
	}
	
	//-------------------------------------

	public Integer getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(Integer repetitions) {
		this.repetitions = repetitions;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

}
