package com.CoachPlan.dto;


public class StudentDTO extends User implements IData {
	
	private String athleteID; //primary key for connecting Student to workout
	
	
	public StudentDTO(String title, String email, String fName, String password, String coachId, String athleteID) {
		super(title, email, fName, password, coachId);
		this.setAthleteID(athleteID);
	}

	
	@Override
	public String toString() {
		return this.getUserName();
	}


	public String getAthleteID() {
		return athleteID;
	}


	public void setAthleteID(String athleteID) {
		this.athleteID = athleteID;
	}

}
