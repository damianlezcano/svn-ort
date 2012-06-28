package service;

import model.Group;
import model.User;
import persistence.EntityManager;

public class GroupServiceBean {
	private EntityManager entityManager;
	
	/**
	 * Permite dar de alta un Grupo en un Usuario
	 */
	public void create(User user, Group group){
		entityManager.create(group);
	}
	
}
