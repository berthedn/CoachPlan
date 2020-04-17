package com.CoachPlan.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO extends User implements IData {
	
	private String athleteID; //primary key for connecting Student to workout
	private ArrayList<String> workouts;
	private String mondayWorkout = "";
	private String tuesdayWorkout = "";
	private String wednesdayWorkout = "";
	private String thursdayWorkout = "";
	private String fridayWorkout = "";
	private String saturdayWorkout = "";
	private String sundayWorkout = "";
	
	public StudentDTO(String title, String email, String fName, String password, String coachId, String athleteID) {
		super(title, email, fName, password, coachId);
		this.athleteID = athleteID;
		workouts = new ArrayList<String>();
		do {
			workouts.add("");
		} while (workouts.size() < 7);
	}
	
	public StudentDTO(String title, String email, String userName, String password, String coachId, String athleteID, ArrayList<String> workouts) {
		super(title, email, userName, password, coachId);
		this.athleteID = athleteID;
		this.workouts = new ArrayList<String>(workouts);
	}
	
	//TODO comment this out when it's done
	public StudentDTO(String sun, String mon, String tues, String wed, String thurs, String fri, String sat) {
		super();
		this.mondayWorkout = mon;
		this.tuesdayWorkout = tues;
		this.wednesdayWorkout = wed;
		this.thursdayWorkout = thurs;
		this.fridayWorkout = fri;
		this.saturdayWorkout = sat;
		this.sundayWorkout = sun;
		this.sundayWorkout = sun;
		
		this.workouts = new ArrayList<String>();
		workouts.add(mondayWorkout);
		workouts.add(tuesdayWorkout);
		workouts.add(wednesdayWorkout);
		workouts.add(thursdayWorkout);
		workouts.add(fridayWorkout);
		workouts.add(saturdayWorkout);
		workouts.add(sundayWorkout);

	}
	
	public StudentDTO() {
		super();
		this.workouts = new ArrayList<String>();
		
	}


	
	public String getMondayWorkout() {
		return mondayWorkout;
	}

	public void setMondayWorkout(String mondayWorkout) {
		this.mondayWorkout = mondayWorkout;
		workouts.add( this.mondayWorkout);
	}

	public String getTuesdayWorkout() {
		return tuesdayWorkout;
	}

	public void setTuesdayWorkout(String tuesdayWorkout) {
		this.tuesdayWorkout = tuesdayWorkout;
		workouts.add( this.tuesdayWorkout);

	}

	public String getWednesdayWorkout() {
		return wednesdayWorkout;
	}

	public void setWednesdayWorkout(String wedesdayWorkout) {
		this.wednesdayWorkout = wedesdayWorkout;
		workouts.add( this.wednesdayWorkout);
	}

	public String getThursdayWorkout() {
		return thursdayWorkout;
	}

	public void setThursdayWorkout(String thursdayWorkout) {
		this.thursdayWorkout = thursdayWorkout;
		workouts.add( this.thursdayWorkout);
	}

	public String getFridayWorkout() {
		return fridayWorkout;
	}

	public void setFridayWorkout(String fridayWorkout) {
		this.fridayWorkout = fridayWorkout;
		workouts.add( this.fridayWorkout);
	}

	public String getSaturdayWorkout() {
		return saturdayWorkout;
	}

	public void setSaturdayWorkout(String saturdayWorkout) {
		this.saturdayWorkout = saturdayWorkout;
		workouts.add( this.saturdayWorkout);

	}

	public String getSundayWorkout() {
		return sundayWorkout;

	}

	public void setSundayWorkout(String sundayWorkout) {
		this.sundayWorkout = sundayWorkout;
		workouts.add( this.sundayWorkout);
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

		this.workouts = workouts;
	}
	
	public ArrayList<String> getWorkouts(){
		return (ArrayList<String>) this.workouts;
	}

}
