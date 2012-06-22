package web;

import java.util.List;

import model.TrainingPlan;
import model.TrainingRoutine;
import model.User;

public class TrainingPlanController {

	private User user;
	
	private TrainingPlan trainingPlan;

	public void save(){
	}
	
	public List<TrainingRoutine> getTrainingRoutines(){
		return null;
	}
	
	public void trainingRoutineSelected(TrainingRoutine trainingRoutine){
		
	}
	
	public boolean validate(){
		return false;
	}
	
	public void setTrainingPlan(TrainingPlan trainingPlan) {
		this.trainingPlan = trainingPlan;
	}

	public TrainingPlan getTrainingPlan() {
		return trainingPlan;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	
	
}
