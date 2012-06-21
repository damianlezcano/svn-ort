package model;


import java.util.List;

/**
 * Rutina de Entrenamiento
 */
public class TrainerRoutine {
	
	/**
	 * Nombre del plan de entrenamiento
	 */
	private String name;
	
	/**
	 * Nombre del plan de entrenamiento
	 */
	private String description;
	
	/**
	 * Son las actividades que componen la rutina
	 */
	private List<IActivity> activities;
	
	//---------------------------------

	public void addActivity(IActivity element) {
	}
	
	public List<IActivity> getActivity() {
		return activities;
	}
	
	public List<IActivity> searchActivity() {
		return activities;
	}
	
	public void newRoutine (String name, String description, List<IActivity> activities){
	}
	
	
	public String getRoutine () {
		return name;
	}
	
	
}
