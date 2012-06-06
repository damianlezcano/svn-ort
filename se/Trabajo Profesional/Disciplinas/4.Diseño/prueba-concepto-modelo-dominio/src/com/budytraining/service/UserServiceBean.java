package com.budytraining.service;

import java.util.List;

import com.budytraining.model.EntityManager;
import com.budytraining.model.User;

public class UserServiceBean {
	
	private EntityManager entityManager;
	private EmailServiceBean emailServiceBean;
	
	/**
	 * Permite dar de alta un usuario (Deportista o Entrenador)
	 */
	public void create(User user){
		entityManager.create(user);
		emailServiceBean.send(user);
	}

	/**
	 * Permite eliminar un usuario ya creado (Deportista o Entrenador)
	 */
	public void remove(User user){
		entityManager.delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> find(User user) {
        return entityManager.find(user).getListResult();
	}

	public void update(User user) {
		entityManager.update(user);
	}

	public User isRegistred(String name, String password) {
		return (User) entityManager.find(name, password).getSingleResult();
	}
	
}
