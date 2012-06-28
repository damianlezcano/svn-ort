package model;

import java.util.List;


/**
 * Grupo
 */
public class Group implements ITrainable {
	
	private List<Sportsman> sportsmans;
	
	private TrainingPlan trainingPlan;

	public void setSportsmans(List<Sportsman> sportsmans) {
		this.sportsmans = sportsmans;
	}

	public List<Sportsman> getSportsmans() {
		return sportsmans;
	}

	public void setTrainingPlan(TrainingPlan trainingPlan) {
		this.trainingPlan = trainingPlan;
	}

	public TrainingPlan getTrainingPlan() {
		return trainingPlan;
	}
	public void addSportsmans(List<Sportsman> sportsmans) {
		this.sportsmans.addAll(sportsmans);
	}	
	
}
