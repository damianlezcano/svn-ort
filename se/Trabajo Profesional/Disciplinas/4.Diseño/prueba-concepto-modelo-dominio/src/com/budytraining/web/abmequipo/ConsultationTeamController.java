package com.budytraining.web.abmequipo;

import java.util.List;

import com.budytraining.model.Team;
import com.budytraining.model.User;
import com.budytraining.service.UserServiceBean;

/**
 * CU8: Consultando Equipo
 */
public class ConsultationTeamController {

	// Servicios
	private UserServiceBean userServiceBean;
	
	// Usuario logeado en el sistema, en este caso de tipo entrenador
	private User user;
	
	// Datos para la busqueda
	private Team team;
	
	// Equipo seleccionado para la Modificacion o Eliminacion
	private Team teamSelected;
	
	// Busco los equipos pertenecientes al entrenador
	public List<Team> find(){
		return null;
	}
	
	public void selected(Team team){
		teamSelected = team;
	}
	
}