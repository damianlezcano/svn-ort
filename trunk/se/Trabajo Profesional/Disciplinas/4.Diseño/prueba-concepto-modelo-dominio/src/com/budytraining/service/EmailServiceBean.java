package com.budytraining.service;

import com.budytraining.model.User;

public class EmailServiceBean {

	public void send(User user) {
		System.out.println("Enviado mail a usuario" + user.getName());
	}
	
}
