package com.CoachPlan.dto;

import java.util.ArrayList;

public class CoachDTO extends User implements IData {
	
	private String id; // use this as a primary key? 
	private ArrayList<StudentDTO> studentList;
	
	
	public CoachDTO(String title, String email, String firstName, String lastName, String password) {
		super(title, email, firstName, lastName, password);
		
		studentList = new ArrayList<StudentDTO>();
		//TODO remove below!!
		StudentDTO student1 = new StudentDTO("eaguila", "loboeder@yo.com", "Eder", "Aguilar", "crunchies");
		StudentDTO student2 = new StudentDTO("swerve", "swerver@yo.com", "Khalil", "Auguste", "yolo");
		StudentDTO student3 = new StudentDTO("damien", "damien@yo.com", "Damien", "Berthenet", "france");
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
	}

	
	//overriding to string method so that we can display the login ID of coach in login page
	@Override
	public String toString() {
		String data = "";
		for(StudentDTO student: this.studentList) {
			data += student.toString() + " ";
		}
		return data;
	}
	
	public void setStudentList(ArrayList<StudentDTO> list) {
		studentList = new ArrayList<StudentDTO>();
		this.studentList = list;
	}
	
	public ArrayList<StudentDTO> getStudentList(){
		return this.studentList;
	}

}
