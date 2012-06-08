package web;


import model.Sportsman;
import model.User;
import service.UserServiceBean;

/**
 * CU2: Dando de Baja un Deportista
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
