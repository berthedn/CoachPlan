package com.CoachPlan.dto;

import java.util.ArrayList;

public class WorkoutDTO {
	
	private ArrayList<String> workouts; //workouts will be stored in this collection
	private int athleteId;
	private String day = "";
	

	//when creating a new workoutDTO, we need to be supplied an athlete ID to tie the workout to athlete
	public WorkoutDTO(String workout, int id) {
		this.workouts = new ArrayList<String>();
		workouts.add(workout);
		this.athleteId = id;
	}
	
	
	public void addWorkout(String workout) {
		this.workouts.add(workout);
	}
	
	public ArrayList<String> getWorkouts(){
		return this.workouts;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public String getDay() {
		return this.day;
	}
	
	public int getAthleteId() {
		return this.athleteId;
	}
	
	public void setAthleteId(int id) {
		this.athleteId = id;
	}

}
