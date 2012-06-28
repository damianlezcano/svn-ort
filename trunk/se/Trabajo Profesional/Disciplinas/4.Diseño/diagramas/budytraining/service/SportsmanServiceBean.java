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
	public void create(User user, Sportsman sportsman){
		entityManager.create(sportsman);
	}

	@SuppressWarnings("unchecked")
	public List<Sportsman> find(Sportsman sportsman) {
        return entityManager.find(sportsman).getListResult();
	}

	@SuppressWarnings("unchecked")
	public List<Sportsman> find(User user) {
        return entityManager.find(user).getListResult();
	}
	
	public void update(Sportsman sportsman) {
		entityManager.update(sportsman);
	}
	
}
