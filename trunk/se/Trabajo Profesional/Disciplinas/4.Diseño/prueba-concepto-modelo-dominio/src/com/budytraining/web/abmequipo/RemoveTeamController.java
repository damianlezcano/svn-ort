package com.budytraining.web.abmequipo;

import com.budytraining.model.Coach;
import com.budytraining.model.Team;
import com.budytraining.model.User;
import com.budytraining.service.UserServiceBean;

/**
 * CU6: Dando de Baja un Equipo
 */
public class RemoveTeamController {

	//Servicios
	private UserServiceBean userServiceBean;
	
	// Usuario logeado, en este caso de tipo entrenador
	private User user;
	
	// Equipo elejido para eliminar en la pagina de consulta
	private Team teamSelected;
	
	public void remove(){
		//Removemos el equipo (se hace por referencia)
		Coach coach = (Coach) user;
		coach.getTeams().remove(teamSelected);
		userServiceBean.update(user);
	}
	
}
