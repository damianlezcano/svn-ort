package model;

import java.util.List;

public class Professional extends User {

	private List<ITrainable> iTrainables;
	private List<TrainingPlan> trainingPlan;

	public void setiTrainables(List<ITrainable> iTrainables) {
		this.iTrainables = iTrainables;
	}

	public List<ITrainable> getiTrainables() {
		return iTrainables;
	}
	
	public List<TrainingPlan> getTrainingPlan() {
		return trainingPlan;
	}

	public void setTrainingPlan(List<TrainingPlan> trainingPlan) {
		this.trainingPlan = trainingPlan;
	}

	@Override
	public String getRole() {
		return "PROFESSIONAL";
	}
	
}
