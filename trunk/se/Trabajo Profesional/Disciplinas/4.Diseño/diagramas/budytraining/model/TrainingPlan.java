package model;


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
	
	//-----

}
