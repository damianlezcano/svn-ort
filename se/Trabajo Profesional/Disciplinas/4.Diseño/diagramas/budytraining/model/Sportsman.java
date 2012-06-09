package model;

import java.util.List;


/**
 * Deportista
 */
public class Sportsman implements ITrainable {
	
	private List<TrainingPlan> trainingPlans;
	
	private SportsmanAttribute sportsmanAttribute;
	
	public TrainingPlan getActualTrainingPlan(){
		return null;
	}


}
