package com.budytraining.web.abmatleta;

import com.budytraining.model.Coach;
import com.budytraining.model.Sportsman;
import com.budytraining.model.Team;
import com.budytraining.model.User;
import com.budytraining.service.UserServiceBean;

/**
 * CU1: Dando de Alta Atleta
 */
public class CreateNewSportmanController {

	//Servicios
	private UserServiceBean userServiceBean;
	
	// Usuario logeado en el sistema, en este caso de tipo entrenador
	private User user;
	
	// Datos del nuevo atleta
	private Sportsman sportman;
	
	public void save(){
		Coach coach = (Coach) user;
		
		//TODO ver de modificar el CU (como agrego el nombre?)
		Team team = new Team();
		team.addSportsman(sportman);
		coach.addTeam(team);
		
		//Agregamos el atleta al equipo del entrenador
		userServiceBean.update(coach);
	}
	
}
