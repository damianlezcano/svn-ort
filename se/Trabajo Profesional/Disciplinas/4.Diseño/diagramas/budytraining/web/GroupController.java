package web;

import java.util.List;

import model.Sportsman;
import model.TrainingLog;

public class GroupController {
	
	private List<TrainingLog> trainingLogs;
	
	public void selectSportsman(Sportsman sportsman){
		
	}
	
	public List<GraphItemView> generateSpeedRegisters(){
		return null;
	}
	
	public List<GraphItemView> generateResistenceRegisters(){
		return null;
	}

	public List<GraphItemView> generateWeightRegisters(){
		return null;
	}

	public List<GraphItemView> generateForceRegisters(){
		return null;
	}

	//Biceps
	public List<GraphItemView> generateMusclesBicepsRegisters(){
		return null;
	}
	
	//Triceps
	public List<GraphItemView> generateTricepsBicepsRegisters(){
		return null;
	}

	public List<TrainingLog> getTrainingLogs() {
		return trainingLogs;
	}

	public void setTrainingLogs(List<TrainingLog> trainingLogs) {
		this.trainingLogs = trainingLogs;
	}
	
}
