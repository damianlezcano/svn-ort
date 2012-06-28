package service;

import java.util.List;

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
	
	/**
	 * Busco los grupos ACTIVOS Y QUE TENGAN UN PLAN ASOCIADO de un usuario professional
	 */
	public List<Group> find(User user){
		return null;
	}
	
	public void update(Group group){
		entityManager.update(group);
	}
	
}
