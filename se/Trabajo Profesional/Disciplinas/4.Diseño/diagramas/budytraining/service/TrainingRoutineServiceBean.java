package service;

import java.util.List;

import model.TrainingRoutine;
import model.User;
import persistence.EntityManager;

public class TrainingRoutineServiceBean {

	private EntityManager entityManager;
	
	public List<TrainingRoutine> find(User user){
		return null;
	}
	
	/**
	 * Permite dar de alta una Rutina
	 */	
	public void create(User user, TrainingRoutine trainingRoutine){
		entityManager.create(trainingRoutine);
	}

	public void update(TrainingRoutine trainingRoutine) {
		entityManager.update(trainingRoutine);		
	}
}
