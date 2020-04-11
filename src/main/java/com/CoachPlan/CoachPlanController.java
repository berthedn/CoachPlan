package com.CoachPlan;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.CoachPlan.dto.CoachDTO;
import com.CoachPlan.dto.StudentDTO;
import com.CoachPlan.dto.WorkoutDTO;
import com.CoachPlan.service.FirebaseService;
import com.CoachPlan.service.ICoachService;

@Controller
public class CoachPlanController {
	
	//Need a service stub interface declared here. What should we call it? Will there be a separate one for coach and student? 
	//(Service stub will be used for backend database calls, think CRUD (create, read update, delete)). 
	//Also need to come up with a DTO class. Do we want to use different DTO classes for coach and student as well? 
	@Autowired
	private ICoachService coachService;
	
	@Autowired
	FirebaseService firebaseService;
	
	String sessionId = "";
	String sessionName = "";
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		sessionId = "";
		sessionName = "";
		
		return "index";
	}
	
	@RequestMapping(value="/setUser", method=RequestMethod.GET)
	public void setCurrentUser(@RequestParam(value="email") String email) throws InterruptedException, ExecutionException {
		sessionId = firebaseService.getUserId(email);
		sessionName = firebaseService.getUserName(email);
		
	}
	
	//this will be the initial athlete page when logged in as an athlete
	@RequestMapping("/athlete")
	public String athletePage() {
		return "athlete";
	}
	
	@RequestMapping("/athleteList")
	public ModelAndView athleteList() throws InterruptedException, ExecutionException {
		//CoachDTO coach = firebaseService.getCoach(sessionName, sessionId);
		//ArrayList<StudentDTO> students = firebaseService.getStudentList(sessionId);
		CoachDTO coach = new CoachDTO("Mr", "loboeder@hello", "eaguila", "jklfds;a", "43214");
		ArrayList<StudentDTO> students = coach.getStudentList();
		ModelAndView view = new ModelAndView();
		view.setViewName("athleteList");
		view.addObject("students", students);
		view.addObject("coach", coach);
		return view;
	}
	
	//page for coaches to edit their athlete schedules
	@RequestMapping("/edit")
	public String editAthlete() {
		return "editAthlete";
	}
	
	//Add new coach to database
	@RequestMapping(value="/registerCoach", method=RequestMethod.GET)
	public String registerCoach(@RequestParam(value="name") String userName, @RequestParam(value="email") String email, @RequestParam(value="password") String password) throws InterruptedException, ExecutionException {
		String ID = "1";
		String coachId = firebaseService.getNextId();
		
		CoachDTO newUser = new CoachDTO(ID, email, userName, password, coachId);
		firebaseService.saveCoachDetails(newUser);
		return "index";
	}
	
	@RequestMapping("/registerAthlete")
	public String registerAthlete() {
		return "registerAthlete";
	}
	
	//Add new athlete to database
	@RequestMapping(value="/addAthlete", method=RequestMethod.GET)
	public String registerAthlete(@RequestParam(value="name") String userName, @RequestParam(value="email") String email, @RequestParam(value="password") String password) throws InterruptedException, ExecutionException {
		String ID = "2";
		String coachId = sessionId;
		String athleteID = userName + " " + password;
		WorkoutDTO workout = new WorkoutDTO(athleteID,"10 Jumping Jacks","10 Squats","10 minute run","10 Crunches","10 Push-ups","Rest","Rest");
		StudentDTO newUser = new StudentDTO(ID, email, userName, password, coachId, athleteID);
		firebaseService.saveAthleteDetails(newUser, workout);
		return "athleteList";
	}
	
}
