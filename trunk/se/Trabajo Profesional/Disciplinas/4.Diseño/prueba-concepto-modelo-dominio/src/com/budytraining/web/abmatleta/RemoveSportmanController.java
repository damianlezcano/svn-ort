package com.budytraining.web.abmatleta;

import com.budytraining.model.Sportsman;
import com.budytraining.model.User;
import com.budytraining.service.UserServiceBean;

/**
 * CU2: Dando de Baja un Atleta
 */
public class RemoveSportmanController {

	//Servicios
	private UserServiceBean userServiceBean;
	
	// Usuario logeado, en este caso de tipo entrenador
	private User user;
	
	// Atleta elejido para eliminar en la pagina de consulta
	private Sportsman sportsmanSelected;
	
	public void remove(){
		//Removemos el atleta al equipo del entrenador
		userServiceBean.remove(sportsmanSelected);
	}
	
}
