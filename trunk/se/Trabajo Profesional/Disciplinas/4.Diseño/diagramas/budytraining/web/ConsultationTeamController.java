package web;


import java.util.List;

import model.Group;
import model.User;
import service.UserServiceBean;

/**
 * CU8: Consultando Equipo
 */
public class ConsultationTeamController {

	// Servicios
	private UserServiceBean userServiceBean;
	
	// Usuario logeado en el sistema, en este caso de tipo entrenador
	private User user;
	
	// Datos para la busqueda
	private Group team;
	
	// Equipo seleccionado para la Modificacion o Eliminacion
	private Group teamSelected;
	
	// Busco los equipos pertenecientes al entrenador
	public List<Group> find(){
		return null;
	}
	
	public void selected(Group team){
		teamSelected = team;
	}
	
}