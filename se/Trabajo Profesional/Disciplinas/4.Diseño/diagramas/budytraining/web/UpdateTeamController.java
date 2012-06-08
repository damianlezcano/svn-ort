package web;


import model.Team;
import model.User;
import service.UserServiceBean;

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
