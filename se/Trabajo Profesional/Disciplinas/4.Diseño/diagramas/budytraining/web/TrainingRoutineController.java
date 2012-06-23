package web;

import java.util.List;

import model.IActivity;
import model.TrainingRoutine;
import model.User;
import service.TrainingRoutineServiceBean;

public class TrainingRoutineController {

	private TrainingRoutine trainingRoutine;
	private TrainingRoutineServiceBean trainingRoutineServiceBean;
	private User user;
	
	public void newRoutine(){
		
	}
	
	public void selectActivities(List<IActivity> multiple){
	}
	
	public void save(){
		trainingRoutineServiceBean.create(user, trainingRoutine);
	}
	
	public void selectTrainingRoutine(TrainingRoutine trainingRoutine){
		
	}
	
	public void edit(){
		trainingRoutineServiceBean.update(trainingRoutine);
	}
	
	
	public boolean validator(){
		return false;
		
	}

	public TrainingRoutine getTrainingRoutine() {
		return trainingRoutine;
	}
	
	public void setTrainingRoutine(TrainingRoutine trainingRoutine) {
		this.trainingRoutine = trainingRoutine;
	}
	
	public List<TrainingRoutine> find(){
		return null;
	}
}
