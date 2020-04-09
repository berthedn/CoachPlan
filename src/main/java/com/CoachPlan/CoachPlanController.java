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
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	//this will be the initial athlete page when logged in as an athlete
	@RequestMapping("/athlete")
	public String athletePage() {
		return "athlete";
	}
	
	//this will be the initial coach page when coach is logged in
//	@RequestMapping("/athleteList")
//	public String athleteList(Model model) {
//		CoachDTO coachDTO = coachService.loginByID("mechalobo");
//		model.addAttribute("coachDTO", coachDTO);
//		return "athleteList";
//	}
	
	@RequestMapping("/athleteList")
	public ModelAndView athleteList() {
		ModelAndView view = new ModelAndView();
		CoachDTO coach = coachService.loginByID("mechalobo");
		//firebase method to return list of athletes for specific user
		ArrayList<StudentDTO> students = coach.getStudentList();
		view.setViewName("athleteList");
		view.addObject("students", students);
		return view;
	}
	
	//page for coaches to edit their athlete schedules
	@RequestMapping("/edit")
	public String editAthlete() {
		return "editAthlete";
	}
	
	//Add new coach to database
	@RequestMapping(value="/registerCoach", method=RequestMethod.GET)
	public String registerCoach(@RequestParam(value="name") String fName, @RequestParam(value="email") String email, @RequestParam(value="password") String password) throws InterruptedException, ExecutionException {
		String ID = "1";
		String coachId = firebaseService.getNextId();
		
		CoachDTO newUser = new CoachDTO(ID, email, fName, password, coachId);
		firebaseService.saveUserDetails(newUser);
		return "index";
	}
	
	@RequestMapping("/registerAthlete")
	public String registerAthlete() {
		return "registerAthlete";
	}
	
	//Add new athlete to database
	@RequestMapping(value="/addAthlete", method=RequestMethod.GET)
	public String registerAthlete(@RequestParam(value="name") String firstName, @RequestParam(value="email") String email, @RequestParam(value="password") String password) throws InterruptedException, ExecutionException {
		String ID = "2";
		String coachId = "0";
		StudentDTO newUser = new StudentDTO(ID, email, firstName, password, coachId);
		firebaseService.saveUserDetails(newUser);
		return "athleteList";
	}
	
}
