package web;

import java.io.File;
import java.util.List;

import model.Sportsman;
import model.TrainingLog;
import model.User;
import service.EmailServiceBean;

public class GraphicController {
	
	private User user;
	private List<TrainingLog> trainingLogs;
	private EmailServiceBean emailServiceBean;
	private UIGraph linegraph;
	
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
	
	private File generateImage(){
		//return lineGraph.getImageView()
		return null;
	}
	
	public void sendMail(Sportsman sportsman){
		//el segundo parametro contiene un mapa con el mensaje a enviar junto con las imagenes como archhivos adjuntos.
		//map.put("attach", lineGraph.getImageView());
		//map.put("subject", "Evnio de grafica al usuario seleccionado")
		emailServiceBean.send(sportsman, null);
	}
	
}
