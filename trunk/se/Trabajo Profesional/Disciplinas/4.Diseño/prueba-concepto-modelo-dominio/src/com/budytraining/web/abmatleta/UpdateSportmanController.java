package com.budytraining.web.abmatleta;

import com.budytraining.model.Sportsman;
import com.budytraining.model.User;
import com.budytraining.service.UserServiceBean;

/**
 * CU3: Modificando Deportista
 */
public class UpdateSportmanController {

	//Servicios
	private UserServiceBean userServiceBean;
	
	// Usuario logeado, en este caso de tipo entrenador
	private User user;
	
	// Atleta elejido para actualizar en la pagina de consulta
	private Sportsman sportsmanSelected;
	
	public void update(){
		//Removemos el deportista al equipo del entrenador
		userServiceBean.update(sportsmanSelected);
	}
	
}
