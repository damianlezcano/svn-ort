package com.budytraining.model;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Rutina de Entrenamiento
 */
public class TrainingRoutine {
	
	/**
	 * Nombre de la rutina de entrenamiento
	 */
	private String name;
	
	/**
	 * Fecha en la que se realizo la rutina, debe estar comprendida entre la fecha del plan de la que depende
	 */
	private Date dateOfRealization;
	
	/**
	 * Cada cuanto se ejecuta la rutina dependiendo de la unidad de medida.
	 * <br>
	 * Ejemplo: 
	 * <li> 2 veces por dia
	 * <li> 2 veces por semana
	 * <li> 2 veces por mes
	 */
	private IPeriodicity periodicity;

	/**
	 * Son las actividades que componen la rutina
	 */
	private List<Activity> activities;
	
	//---------------------------------

	//Constructor vacio
	public TrainingRoutine(){
		dateOfRealization = new Date();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TrainingRoutine(TrainingRoutine clone) {
		this();
		this.name = clone.name;
		this.periodicity = clone.periodicity;
		
		for (Activity element : clone.activities) {
			try {
				
				// constructor que vamos a utilizar
				Class cArgs[] = { element.getClass() };
				Object oParams[] = { element };

				// obtengo el constructor que recibe (en este caso) un String
				Class clazz = Class.forName(element.getClass().getName());
				Constructor ctor = clazz.getConstructor(cArgs);

				// invoco el constructor pasandole los argumentos que espera
				Object obj = ctor.newInstance(oParams);
				
				//Agrego la actividad realizada
				addActivity((Activity)obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addActivity(Activity element) {
		if (activities == null) {
			activities = new ArrayList<Activity>();
		}
		activities.add(element);
	}

	//----
	public Date getDateOfRealization() {
		return dateOfRealization;
	}

	public void setDateOfRealization(Date dateOfRealization) {
		this.dateOfRealization = dateOfRealization;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IPeriodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(IPeriodicity periodicity) {
		this.periodicity = periodicity;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

//	/**
//	 * Fecha en la que se va a estimar que se realizara la tarea
//	 */
//	private Date estimatedDate;
//	/**
//	 * Cada cuanto se ejecuta la rutina dependiendo de la unidad de medida.
//	 * <br>
//	 * Ejemplo: 
//	 * <li> 2 veces por dia
//	 * <li> 2 veces por semana
//	 * <li> 2 veces por mes
//	 */
//	private Integer periodicity;
//	
//	/**
//	 * Unidad de medida (Dia, Semana, Mes)
//	 */
//	private MeasuringUnit unit;
//	
//	/**
//	 * Este dato es opcional, es para darle un dia a la semana para ejecutar la rutina
//	 */
//	private DayOfWeek dayOfWeek;
//	/**
//	 * Las actividades que deberia realizar (no se puede modificar)
//	 * En el caso que la tarea necesite hacerse en varias sesiones, 
//	 * se generara el numero de actividades necesarias para las sessiones.
//	 * Ejemplo: Para la actividad "pesas" si se necesita hacer 2 sessiones de 20 repeticiones cada una,
//	 * se generaran 2 actividades en las que contendran en su atributo de repeticiones el valor 20.
//	 */
//	private List<Activity> estimated;
//	
//	/**
//	 * Las actividades realizadas verdaderamente (esto se compara con las estimadas)
//	 */
//	private List<Activity> real;
//	public void addEstimated(Activity element){
//		if(estimated == null){
//			estimated = new ArrayList<Activity>();
//		}
//		estimated.add(element);
//	}
//	
//	public void addReal(Activity element){
//		if(real == null){
//			real = new ArrayList<Activity>();
//		}
//		real.add(element);
//	}
	
}
