package model;

import java.sql.Date;
import java.util.List;


/**
 * Deportista
 */
public class Sportsman implements ITrainable {
	
	private List<TrainingPlan> trainingPlans;
	
	private String name;
	private String lastName;
	private Date date;
	private String phone;
	private String eMail;
	private boolean active;
	private boolean activeGroup;
	
	private String diseases;
	private String injuries;
	private String treatment;
	private String medicalDrugsTreatment;
	private String sleepTime;
	
	private SportsmanAttribute sportmanAttribute;
	
	public TrainingPlan getActualTrainingPlan(){
		return null;
	}

	//---
	public List<TrainingPlan> getTrainingPlans() {
		return trainingPlans;
	}

	public void setTrainingPlans(List<TrainingPlan> trainingPlans) {
		this.trainingPlans = trainingPlans;
	}
	
	public void addTrainingPlan(TrainingPlan trainigPlan) {
		this.trainingPlans.add(trainigPlan);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActiveGroup() {
		return activeGroup;
	}

	public void setActiveGroup(boolean activeGroup) {
		this.activeGroup = activeGroup;
	}

	public String getDiseases() {
		return diseases;
	}

	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}

	public String getInjuries() {
		return injuries;
	}

	public void setInjuries(String injuries) {
		this.injuries = injuries;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getMedicalDrugsTreatment() {
		return medicalDrugsTreatment;
	}

	public void setMedicalDrugsTreatment(String medicalDrugsTreatment) {
		this.medicalDrugsTreatment = medicalDrugsTreatment;
	}

	public String getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(String sleepTime) {
		this.sleepTime = sleepTime;
	}

	public SportsmanAttribute getSportmanAttribute() {
		return sportmanAttribute;
	}

	public void setSportmanAttribute(SportsmanAttribute sportmanAttribute) {
		this.sportmanAttribute = sportmanAttribute;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
