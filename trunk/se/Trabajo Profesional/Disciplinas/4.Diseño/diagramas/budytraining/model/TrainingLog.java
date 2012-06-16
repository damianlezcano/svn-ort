package model;

import java.util.Date;
import java.util.List;

public class TrainingLog {

	private Date logDate;
	private List<IActivity> activities;
	
	private SportsmanAttribute sportsmanAttribute;

	//---
	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public List<IActivity> getActivities() {
		return activities;
	}

	public void setActivities(List<IActivity> activities) {
		this.activities = activities;
	}

	public SportsmanAttribute getSportsmanAttribute() {
		return sportsmanAttribute;
	}

	public void setSportsmanAttribute(SportsmanAttribute sportsmanAttribute) {
		this.sportsmanAttribute = sportsmanAttribute;
	}
	
}
