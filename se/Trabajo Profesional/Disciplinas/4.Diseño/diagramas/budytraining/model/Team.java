package model;


import java.util.ArrayList;
import java.util.List;

/**
 * Equimpo
 */
public class Team {
	
	/**
	 * Nombre del equipo
	 */
	private String name;
	
	/**
	 * Descripcion opcional
	 */
	private String description;
	
	/**
	 * Integrantes del equipo
	 */
	private List<Sportsman> sportsmans;
	
	/**
	 * Objetivo actual, es el que se esta ejecutando
	 */
	private Objetive objetive;
	
	//---------------------------------------
	
	public void addSportsman(Sportsman element){
		if(sportsmans == null){
			sportsmans = new ArrayList<Sportsman>();
		}
		element.setEstimated(new Objetive(objetive));//Agrego los objetivos del equipo al deportista agregado.
		element.setCompleted(new Objetive(objetive));
		element.getCompleted().getPlan().getRoutines().clear();
		
		sportsmans.add(element);
	}

	//---
	public List<Sportsman> getSportsmans() {
		return sportsmans;
	}

	public void setSportsmans(List<Sportsman> sportsmans) {
		this.sportsmans = sportsmans;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Objetive getObjetive() {
		return objetive;
	}

	public void setObjetive(Objetive objetive) {
		this.objetive = objetive;
	}
	
//	/**
//	 * El historial de los Objetivos (son los objetivos finalizados)
//	 */
//	private List<Objetive> historyObjetives;
//	public void addHistoryObjective(Objetive element){
//		if(historyObjetives == null){
//			historyObjetives = new ArrayList<Objetive>();
//		}
//		historyObjetives.add(element);
//	}	
}
