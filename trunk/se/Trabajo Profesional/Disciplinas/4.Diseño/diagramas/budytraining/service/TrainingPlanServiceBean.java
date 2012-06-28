package service;

import model.TrainingPlan;
import persistence.EntityManager;

public class TrainingPlanServiceBean {
	private EntityManager entityManager;
	
	/**
	 * Permite dar de alta un Sportsman (Deportista)
	 */
	public void create(TrainingPlan trainingPlan){
		entityManager.create(trainingPlan);
	}

	public void update(TrainingPlan trainingPlan) {
		entityManager.update(trainingPlan);
	}
	
}
