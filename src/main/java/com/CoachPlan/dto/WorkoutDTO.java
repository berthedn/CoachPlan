package com.CoachPlan.dto;

public class WorkoutDTO {
	
	private String athleteID;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String saturday;
	private String sunday;
	

	//when creating a new workoutDTO, we need to be supplied an athlete ID to tie the workout to athlete
	public WorkoutDTO(String athleteID, String monday, String tuesday, String wednesday, 
						String thursday, String friday, String saturday, String sunday) {
		this.athleteID = athleteID;
		this.setMonday(monday);
		this.setTuesday(tuesday);
		this.setWednesday(wednesday);
		this.setThursday(thursday);
		this.setFriday(friday);
		this.setSaturday(saturday);
		this.setSunday(sunday);
	}
	
	public String getAthleteID() {
		return this.athleteID;
	}
	
	public void setAthleteID(String id) {
		this.athleteID = id;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

}
