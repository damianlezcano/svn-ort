package model;


import java.util.Date;

public class Objetive {
	
	/**
	 * Nombre del objetivo del entrenamiento
	 */
	private String name;
	
	/**
	 * Fecha de inicio del objetivo
	 */
	private Date startDate;
	
	/**
	 * Fecha de fin del objetivo  
	 */
	private Date endDate;

	/**
	 * Es el plan que contiene las rutinas de entrenamiento que se estan ejecutando
	 */
	private TrainingPlan plan;
	
	//------------------------------------
	
	//Constructor vacio
	public Objetive(){
	}
	
	//Constructor de copia
	public Objetive(Objetive clone){
		this.name = clone.name;
		this.startDate = clone.startDate;
		this.endDate = clone.endDate;
		this.plan = new TrainingPlan(clone.plan);
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

	public TrainingPlan getPlan() {
		return plan;
	}

	public void setPlan(TrainingPlan plan) {
		this.plan = plan;
	}
	
//	/**
//	 * Historial de las rutinas
//	 */
//	private List<TrainingPlan> historyPlan;
//	public void addHistoryPlan(TrainingPlan element){
//		if(historyPlan == null){
//			historyPlan = new ArrayList<TrainingPlan>();
//		}
//		historyPlan.add(element);
//	}
	
}
