package web;


import model.Coach;
import model.Team;
import model.User;
import service.UserServiceBean;

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
