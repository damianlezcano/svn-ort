package web;

import java.util.List;

import model.Group;
import model.IActivity;
import model.Sportsman;
import model.TrainingLog;
import model.TrainingPlan;
import model.TrainingRoutine;
import model.User;
import service.GroupServiceBean;

public class RegisteringGroupActivityController {

	private User user;
	private GroupServiceBean groupServiceBean;
	
	private Group groupSelected;
	private TrainingRoutine trainingRoutineSelected;
	
	
	
	public List<Group> find(){
		return groupServiceBean.find(user);
	}
	
	public List<Sportsman> getSportsmanOfGroup(){
		return groupSelected.getSportsmans();
	}
	
	public List<IActivity> getActivityOfRoutine(){
		return trainingRoutineSelected.getActivity();
	}
	
	public void selectedGroup(Group group){
	}
	
	public void selectedRoutine(TrainingRoutine trainingRoutineSelected){
		
	}
	
	public void save(){
		
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
	
	public List<TrainingRoutine> getRoutineOfGroup(){
		return groupSelected.getTrainingPlan().getRoutines();
	}

	public Group getGroupSelected() {
		return groupSelected;
	}

	public void setGroupSelected(Group groupSelected) {
		this.groupSelected = groupSelected;
	}

	public TrainingRoutine getTrainingRoutineSelected() {
		return trainingRoutineSelected;
	}

	public void setTrainingRoutineSelected(TrainingRoutine trainingRoutineSelected) {
		this.trainingRoutineSelected = trainingRoutineSelected;
	}
	
}
