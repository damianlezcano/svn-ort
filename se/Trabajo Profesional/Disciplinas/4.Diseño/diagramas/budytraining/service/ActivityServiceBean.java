package service;

import java.util.List;

import model.IActivity;
import persistence.EntityManager;

public class ActivityServiceBean {

	private EntityManager entityManager;
	
	public List<IActivity> findAll() {
        return entityManager.find("buscar todas las actividades").getListResult();
	}
	
}
