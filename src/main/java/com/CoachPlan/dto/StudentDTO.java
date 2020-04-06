package com.CoachPlan.dto;

import java.util.ArrayList;

public class StudentDTO extends User implements IData {
	
	private String id; // foreign key for Student to coach
	private int workoutId; //primary key for connecting Student to workout
	private ArrayList<WorkoutDTO> schedule;
	
	
	public StudentDTO(String title, String email, String fName, String lName, String password) {
		super(title, email, fName, lName, password);
		this.schedule = new ArrayList<WorkoutDTO>();
	}

	
	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getLastName();
	}

}
