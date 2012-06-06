package com.budytraining.model;

import java.util.Date;


public abstract class Activity implements IAdvance {

	/**
	 * Fecha en la que se realizo la tarea, debe estar comprendida entre la fecha de la rutina de entrenamiento (se crea automaticamente con la fecha actual)
	 */
	private Date dateOfRealization;

	//--------------------------------------

	public Activity(){
		dateOfRealization = new Date();
	}
	
	public Date getDateOfRealization() {
		return dateOfRealization;
	}

	public void setDateOfRealization(Date dateOfRealization) {
		this.dateOfRealization = dateOfRealization;
	}
	
}
