package com.CoachPlan.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO extends User implements IData {
	
	private String athleteID; //primary key for connecting Student to workout
	private List<String> workouts;
	
	
	public StudentDTO(String title, String email, String fName, String password, String coachId, String athleteID) {
		super(title, email, fName, password, coachId);
		this.athleteID = athleteID;
		workouts = new ArrayList<String>();
	}
	
	public StudentDTO(String email, String userName, String password, String coachId, String athleteID, ArrayList<String> workouts) {
		super(email, userName, password, coachId);
		this.athleteID = athleteID;
		this.workouts = new ArrayList<String>(workouts);
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
	
	//Need to change this so that a coach can modify Workouts
	public void setWorkouts(ArrayList<String> workouts) {
//		for(String workout : workouts) {
//			this.workouts.add(workout);
//		}
		
		System.out.println(workouts.toString());
	}
	
	public ArrayList<String> getWorkouts(){
		return (ArrayList<String>) this.workouts;
	}

}
