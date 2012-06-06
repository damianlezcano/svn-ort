package com.budytraining.web;

import com.budytraining.model.User;
import com.budytraining.service.UserServiceBean;

/**
 * Pagina de Login
 */
public class LoginController {

	private String name;
	private String password;
	
	//Servicios
	private UserServiceBean userServiceBean;
	
	private User user;
	
	public void autenticate(){
		user = userServiceBean.isRegistred(name, password);
		if(user == null){
			FacesContext.error("Usuario o Contrasena incorrecto");
		}else{
			SessionContextManager.redirect("registrer.jsf");
		}
	}
}
