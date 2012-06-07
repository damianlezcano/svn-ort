package com.budytraining.web.abmatleta;

import java.util.List;

import com.budytraining.model.Coach;
import com.budytraining.model.Sportsman;
import com.budytraining.model.User;
import com.budytraining.service.UserServiceBean;
import com.budytraining.web.SmookUtil;

/**
 * CU4: Consultando Deportista
 */
public class ConsultationSportmanController {

	//Servicios
	private UserServiceBean userServiceBean;
	
	// Usuario logeado en el sistema, en este caso de tipo entrenador
	private Coach user;
	
	// Datos para la busqueda
	private Sportsman sportman;
	
	// Usuario seleccionado para la Modificacion o Eliminacion
	private Sportsman sportmanSelected;
	
	// Resulatado de la busqueda del atleta
	private List<User> result;
	
	/**
	 * Busqueda de atletas del equpo perteneciente al entrenador logeado
	 */
	public List<Sportsman> find(){
		return (List<Sportsman>) SmookUtil.call("userServiceBean","find");
	}
	
	public void selected(Sportsman item){
		sportman = item;
	}
	
}
