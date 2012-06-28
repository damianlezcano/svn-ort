package web;

import java.util.List;

import model.Group;
import model.Sportsman;

import model.User;
import service.GroupServiceBean;
import model.TrainingPlan;

public class GroupController {

	private User user;
	private Group group;
	private GroupServiceBean groupServiceBean;
	
	
	public void newGroup(){
	}
	
	public void save(){
	}
	
	public boolean validate(){
		return true;
	}
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public void setTrainingPlan (TrainingPlan trainingPlan) {
		group.setTrainingPlan(trainingPlan);
	}
	public List<Group> find (){
		return null;
	}
	public void selectGroup(Group group){
		
	}
	public List<Sportsman> getSportsmanList(){
		return group.getSportsmans();
	}
	public void associateSportsman (List<Sportsman> sportsmans){
		
	}
	
}
