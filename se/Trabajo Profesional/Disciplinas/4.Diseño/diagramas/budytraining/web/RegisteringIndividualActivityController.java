package web;

import java.util.List;

import model.IActivity;
import model.Sportsman;
import model.TrainingLog;
import model.TrainingPlan;
import model.TrainingRoutine;
import model.User;
import service.SportsmanServiceBean;

public class RegisteringIndividualActivityController {
	private User user;
	
	private SportsmanServiceBean sportsmanServiceBean;
	
	private Sportsman sportsmanSelected;
		
	private TrainingRoutine trainingRoutineSelected;
	

	public List<IActivity> getActivityOfRoutine(){
		return trainingRoutineSelected.getActivity();
	}
	
	
	public void selectedRoutine(TrainingRoutine trainingRoutineSelected){
		
	}
	
	public void save(){
		
	}
	public List<TrainingRoutine> getRoutineOfSportsman(){
		return sportsmanSelected.getActualTrainingPlan().getRoutines();
	}
	
	public void selectedSportsman(Sportsman sportsman){
	}
	/**
	 * Emulamos un loop desde la pagina, lo que va ir llamando uno por uno a este metodo.
	 */
	public void checkActivityToSportsman(Sportsman sportsman, List<IActivity> activities){
		TrainingPlan traininPlan = sportsman.getActualTrainingPlan();
		TrainingLog trainingLog = null;
		trainingLog.setActivities(activities);
		traininPlan.addTrainingLog(trainingLog);
	}
	

	public TrainingRoutine getTrainingRoutineSelected() {
		return trainingRoutineSelected;
	}

	public void setTrainingRoutineSelected(TrainingRoutine trainingRoutineSelected) {
		this.trainingRoutineSelected = trainingRoutineSelected;
	}
}
