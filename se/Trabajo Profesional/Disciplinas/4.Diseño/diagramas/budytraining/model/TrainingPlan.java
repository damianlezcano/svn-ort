package model;


import java.util.Date;
import java.util.List;

public class TrainingPlan {
	
	/**
	 * Nombre del plan de entrenamiento
	 */
	private String name;
	
	/**
	 * Nombre del plan de entrenamiento
	 */
	private String description;
	
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
	
	//Registro de Actividades.
	private List<TrainingLog> trainingLogs;
	
	//Cuando se empieza el plan de entrenamiento, se establece inicialmente los atributos para luego compararlos y generar una evolucion dentro del plan.
	private SportsmanAttribute initialSportsmanAttribute;
	
	//---
	public String getName() {
		return name;
	}

	public void setName(String name, String description) {
		this.name = name;
		this.setDescription(description);
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
	
	public void newRoutines(String name, String description) {
		
	}

	public List<TrainingLog> getTrainingLogs() {
		return trainingLogs;
	}

	public void setTrainingLogs(List<TrainingLog> trainingLogs) {
		this.trainingLogs = trainingLogs;
	}

	public SportsmanAttribute getInitialSportsmanAttribute() {
		return initialSportsmanAttribute;
	}

	public void setInitialSportsmanAttribute(SportsmanAttribute initialSportsmanAttribute) {
		this.initialSportsmanAttribute = initialSportsmanAttribute;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	//-----

}
