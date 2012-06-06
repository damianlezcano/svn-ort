package com.budytraining.model;


/**
 * Deportista
 */
public class Sportsman extends User {
	
	/**
	 * Objetivo actual, es el que se esta ejecutando
	 */
	private Objetive estimated;
	
	/**
	 * Objetivo actual, es el que se esta ejecutando
	 */
	private Objetive completed;	
	
	/**
	 * Descripcion (Opcional)
	 */
	private String description;

	//-------------------------------

	public Objetive getEstimated() {
		return estimated;
	}

	public void setEstimated(Objetive estimated) {
		this.estimated = estimated;
	}

	public Objetive getCompleted() {
		return completed;
	}

	public void setCompleted(Objetive completed) {
		this.completed = completed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	/**
//	 * El historial de los Objetivos (son los objetivos finalizados)
//	 */
//	private List<Objetive> historyObjetives;
	
	//---------------------------------------
	
//	public void addHistoryObjective(Objetive element){
//		if(historyObjetives == null){
//			historyObjetives = new ArrayList<Objetive>();
//		}
//		historyObjetives.add(element);
//	}

}
