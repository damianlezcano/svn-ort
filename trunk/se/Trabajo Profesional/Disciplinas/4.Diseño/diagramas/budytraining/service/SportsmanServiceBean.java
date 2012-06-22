package service;

import java.util.List;

import model.Sportsman;
import model.User;
import persistence.EntityManager;

public class SportsmanServiceBean {
	private EntityManager entityManager;
	
	/**
	 * Permite dar de alta un Sportsman (Deportista)
	 */
	public void create(Sportsman sportsman){
		entityManager.create(sportsman);
	}

	@SuppressWarnings("unchecked")
	public List<User> find(Sportsman sportsman) {
        return entityManager.find(sportsman).getListResult();
	}

	public void update(Sportsman sportsman) {
		entityManager.update(sportsman);
	}
	
}
