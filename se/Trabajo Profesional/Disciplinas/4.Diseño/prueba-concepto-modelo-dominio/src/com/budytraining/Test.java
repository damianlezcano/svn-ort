package com.budytraining;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;

import com.budytraining.model.Abdominal;
import com.budytraining.model.Activity;
import com.budytraining.model.Coach;
import com.budytraining.model.DayOfWeek;
import com.budytraining.model.Objetive;
import com.budytraining.model.PushUp;
import com.budytraining.model.Sportsman;
import com.budytraining.model.Team;
import com.budytraining.model.TrainingPlan;
import com.budytraining.model.TrainingRoutine;
import com.budytraining.model.User;
import com.budytraining.model.Weekly;

public class Test {

	private User user;
	
	@Before 
	public void loadCoach(){
		
		Coach entrenador = new Coach();
		entrenador.setName("Javier Weber");
		
		//Equipo de voley
		Team voley = new Team();
		voley.setName("Los borbotones");
		voley.setDescription("Equipo de voley");
		entrenador.addTeam(voley);
		
		//Objetivo del entrenamiento
		Objetive objetivo = new Objetive();
		objetivo.setName("Ganar el campeonato 2012");
		objetivo.setStartDate(fd("01-03-2012"));
		objetivo.setEndDate(fd("30-09-2012"));
		voley.setObjetive(objetivo);
		
		//Agrego un plan de entrenamiento compuesto por dos rutinas (abdominales y brazos)
		TrainingPlan plan = new TrainingPlan();
		plan.setName("Trabajar en la velocidad");
		plan.setStartDate(fd("01-03-2012"));
		plan.setEndDate(fd("31-04-2012"));
		objetivo.setPlan(plan);
		
		//-----------------------------------------------
		// RUTINA LUNES
		
		//Agregar rutina de entrenamiento al plan
		TrainingRoutine rutina = new TrainingRoutine();
		rutina.setName("Entrenamiento de Piernas");
		rutina.setPeriodicity(new Weekly(DayOfWeek.MONDAY));
		plan.addRoutine(rutina);
		
		//Agrego actividad a la rutina
		Abdominal abdominal = new Abdominal(20); //Primera session de abdominales de 20 repeticiones cada una
		rutina.addActivity(abdominal);
		
		//Agrego actividad a la rutina
		abdominal = new Abdominal(20); //Segunda session de abdominales de 20 repeticiones cada una
		rutina.addActivity(abdominal);

		// RUTINA MIERCOLES
		
		//Agregar rutina de entrenamiento al plan
		rutina = new TrainingRoutine();
		rutina.setName("Entrenamiento de Brazos");
		rutina.setPeriodicity(new Weekly(DayOfWeek.WEDNESDAY));
		plan.addRoutine(rutina);
		
		//Agrego actividad a la rutina
		PushUp pushUp = new PushUp(10); //Primera session de flexion de brazos de 10 repeticiones cada una
		rutina.addActivity(pushUp);
		
		//Agrego actividad a la rutina
		pushUp = new PushUp(10); //Segunda session de flexion de brazos de 10 repeticiones cada una
		rutina.addActivity(pushUp);
		
		//------------------------------------------------------------------------------
		// UNA VES ARMADO EL OBJETIVO, EL PLAN Y LAS RUTINAS SE ASIGNAN LOS DEPORTISTAS
		//------------------------------------------------------------------------------
		
		//Agrego deportista al equipo
		Sportsman saguero = new Sportsman();
		saguero.setName("Marcelo");
		saguero.setDescription("Saguero por 1");
		voley.addSportsman(saguero);
		
		//Agrego deportista al equipo
		Sportsman centro = new Sportsman();
		centro.setName("Demi");
		centro.setDescription("Centro y Bloquedor");
		voley.addSportsman(centro);

		//Cargamos el entrenador
		this.user = entrenador;
		
	}
	
	@org.junit.Test
	public void calculateAdvance(){
		
		Coach coach = (Coach) user;
		Sportsman saguero = coach.getTeams().get(0).getSportsmans().get(0);
		TrainingRoutine rutina = saguero.getEstimated().getPlan().getRoutineOfTheDay();
		
		Abdominal session = (Abdominal) rutina.getActivities().get(0);
		session.setTime(60f);

		session = (Abdominal) rutina.getActivities().get(1);
		session.setTime(45f);
		
		saguero.getCompleted().getPlan().addRoutine(rutina);
		
		for (TrainingRoutine routine : saguero.getCompleted().getPlan().getRoutines()) {
			for (Activity activity : routine.getActivities()) {
				System.out.println("Session : " + activity.calculate());
			}
		}
		
	}

	//------------------------------------
	//Metodos Auxiliares
	
	/**
	 * Convierte un string en un date
	 * @param fecha dd-MM-yyyy
	 * @return Date.class
	 */
	private Date fd(String fecha) {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = formatoDelTexto.parse(fecha);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return date;
	}
	
	
//	//Equipo de futbol
//	Team futbol = new Team();
//	futbol.setName("Polideportivo Futbol");
//	bocha.addTeam(futbol);
//	
//	Sportsman delantero = new Sportsman();
//	saguero.setName("Nahuel");
//	voley.addSportsman(delantero);
//	
//	Sportsman arquero = new Sportsman();
//	centro.setName("nacho");
//	voley.addSportsman(arquero);
	
}
