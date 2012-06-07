package com.budytraining.web;

import com.budytraining.model.Coach;
import com.budytraining.model.Sportsman;
import com.budytraining.model.User;

/**
 * Pagina: Registrar nuevos clientes
 */
public class RegistrerController {

	private User user;
	
	//Se elije el tipo de usuario a registrar
	public void actionUserTypeListener(UserType type){
		switch (type) {
		case SPORTSMAN:
			user = new Sportsman();
			break;
		case COACH:
			user = new Coach();
			break;
		}
	}
	
	/**
	 * Este metodo llama al servicio UserServiceBean.class para el alta un nuevo usuario
	 */
	public void create(){
		SmookUtil.call("UserServiceBean", "create", user);
	}
	
}
