package com.budytraining.web.abmequipo;

import com.budytraining.model.Team;
import com.budytraining.model.User;
import com.budytraining.service.UserServiceBean;

/**
 * CU7: Modificando Equipo
 */
public class UpdateTeamController {

	//Servicios
	private UserServiceBean userServiceBean;
	
	// Usuario logeado, en este caso de tipo entrenador
	private User user;
	
	// Equipo elejido para actualizar en la pagina de consulta
	private Team teamSelected;
	
	public void update(){
		//Actualizamos el equipo del entrenador
		userServiceBean.update(user);
	}
	
}
