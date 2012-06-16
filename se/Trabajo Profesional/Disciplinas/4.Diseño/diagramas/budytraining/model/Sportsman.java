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

	//---
	public List<TrainingPlan> getTrainingPlans() {
		return trainingPlans;
	}

	public void setTrainingPlans(List<TrainingPlan> trainingPlans) {
		this.trainingPlans = trainingPlans;
	}

	public SportsmanAttribute getSportsmanAttribute() {
		return sportsmanAttribute;
	}

	public void setSportsmanAttribute(SportsmanAttribute sportsmanAttribute) {
		this.sportsmanAttribute = sportsmanAttribute;
	}	

}
