package com.budytraining.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrainingPlan {
	
	/**
	 * Nombre del plan de entrenamiento
	 */
	private String name;
	
	/**
	 * Fecha de inicio del plan (no debe ser inferior a la fecha de inicio del objetivo)
	 */
	private Date startDate;
	
	/**
	 * Fecha de fin del plan (No debe ser superior a la fecha de fin del objetivo)  
	 */
	private Date endDate;
	
	/**
	 * Son las rutinas qeu se deben realizar
	 */
	private List<TrainingRoutine> routines;
	
	//------------------------------------
	
	// Constructor vacio
	public TrainingPlan() {
	}
	
	public TrainingPlan(TrainingPlan clone) {
		this.name = clone.name;
		this.startDate = clone.startDate;
		this.endDate = clone.endDate;
		
		for (TrainingRoutine element : clone.routines) {
			addRoutine(new TrainingRoutine(element));
		}
	}

	public void addRoutine(TrainingRoutine element){
		if(routines == null){
			routines = new ArrayList<TrainingRoutine>();
		}
		routines.add(element);
	}
	
	public TrainingRoutine getRoutineOfTheDay(){
		DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
		for (TrainingRoutine element : routines) {
			if(element.getPeriodicity().getDayOfWeek() == dayOfWeek){
				return new TrainingRoutine(element);
			}
		}
		return null;
	}
	
	//----
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<TrainingRoutine> getRoutines() {
		return routines;
	}

	public void setRoutines(List<TrainingRoutine> routines) {
		this.routines = routines;
	}
	
//	/**
//	 * Rutinas realizadas
//	 */
//	private List<TrainingRoutine> onRoutines;
	
//	/**
//	 * Historial de las rutinas
//	 */
//	private List<TrainingRoutine> historyRoutines;
//	public void addOnRoutine(TrainingRoutine element) {
//		if(onRoutines == null){
//			onRoutines = new ArrayList<TrainingRoutine>();
//		}
//		onRoutines.add(element);
//	}
	
//	public void addHistoryRoutine(TrainingRoutine element){
//		if(historyRoutines == null){
//			historyRoutines = new ArrayList<TrainingRoutine>();
//		}
//		historyRoutines.add(element);
//	}	

}
