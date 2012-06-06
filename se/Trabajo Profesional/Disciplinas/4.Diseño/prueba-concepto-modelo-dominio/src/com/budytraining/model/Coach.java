package com.budytraining.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Entrenador
 */
public class Coach extends User {
	
	/**
	 * Equipos del entrenador
	 */
	private List<Team> teams;
	
	//------------------------------
	
	public void addTeam(Team element){
		if(teams == null){
			teams = new ArrayList<Team>();
		}
		teams.add(element);
	}

	//----
	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
}
