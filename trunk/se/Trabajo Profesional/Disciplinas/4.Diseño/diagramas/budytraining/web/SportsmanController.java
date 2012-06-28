package web;

import model.Sportsman;
import model.TrainingPlan;
import model.User;
import service.SportsmanServiceBean;

public class SportsmanController {
	
	private User user;
	private Sportsman sportsman;
	private SportsmanServiceBean sportsmanServiceBean;

	public void save(){
	}
	
	public void newSportsman(){
	}
	
	public boolean validator(){
		return true;
	}
	
	public void find(){
	}
	
	public void select(Sportsman sportsman){
	}
	
	public void modify(){
	}
	
	public void setSportsman(Sportsman sportsman) {
		this.sportsman = sportsman;
	}

	public Sportsman getSportsman() {
		return sportsman;
	}
	public void setTrainingPlan(TrainingPlan trainingPlan) {
		sportsman.addTrainingPlan(trainingPlan);
	}

}
