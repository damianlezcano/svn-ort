package com.budytraining.model;

/**
 * Periodicidad Semanal
 */
public class Weekly implements IPeriodicity {

	/**
	 * Dia de la semana que se va a ejecutar
	 */
	private DayOfWeek dayOfWeek;

	//----------------------------------
	
	public Weekly(DayOfWeek dayOfWeek) {
		super();
		this.dayOfWeek = dayOfWeek;
	}

	//----
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
}
