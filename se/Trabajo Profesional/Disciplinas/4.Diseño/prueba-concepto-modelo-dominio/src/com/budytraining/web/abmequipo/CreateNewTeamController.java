package com.budytraining.web.abmequipo;

import com.budytraining.model.Coach;
import com.budytraining.model.Team;
import com.budytraining.model.User;
import com.budytraining.service.UserServiceBean;

/**
 * CU5: Dando de Alta Equipo
 */
public class CreateNewTeamController {

	//Servicios
	private UserServiceBean userServiceBean;
	
	// Usuario logeado en el sistema, en este caso de tipo entrenador
	private User user;
	
	// Datos del nuevo entrenador
	private Team team;
	
	public void save(){
		//Agregamos el equipo al entrenador
		Coach coach = (Coach) user;
		coach.addTeam(team);
		userServiceBean.update(coach);
	}
	
}
