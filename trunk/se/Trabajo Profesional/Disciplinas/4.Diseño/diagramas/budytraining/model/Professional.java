package model;

import java.util.List;

public class Professional extends User {

	private List<ITrainable> iTrainables;
	private List<TrainingRoutine> trainingRoutine;
	private List<TrainingPlan> trainingPlan;

	public void setiTrainables(List<ITrainable> iTrainables) {
		this.iTrainables = iTrainables;
	}

	public List<ITrainable> getiTrainables() {
		return iTrainables;
	}

	public List<TrainingRoutine> getTrainingRoutine() {
		return trainingRoutine;
	}

	public void setTrainingRoutine(List<TrainingRoutine> trainingRoutine) {
		this.trainingRoutine = trainingRoutine;
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
