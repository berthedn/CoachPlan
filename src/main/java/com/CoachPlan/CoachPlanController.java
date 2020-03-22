package com.CoachPlan;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CoachPlan.dto.CoachDTO;
import com.CoachPlan.dto.UserDTO;
import com.CoachPlan.service.FirebaseService;
import com.CoachPlan.service.ICoachService;

@Controller
public class CoachPlanController {
	
	//Need a service stub interface declared here. What should we call it? Will there be a separate one for coach and student? 
	//(Service stub will be used for backend database calls, think CRUD (create, read update, delete)). 
	//Also need to come up with a DTO class. Do we want to use different DTO classes for coach and student as well? 
	@Autowired
	private ICoachService coachServiceStub;
	
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
	@RequestMapping("/athleteList")
	public String athleteList(Model model) {
		CoachDTO coachDTO = coachServiceStub.loginByID("mechalobo");
		model.addAttribute("coachDTO", coachDTO);
		return "athleteList";
	}
	
	//page for coaches to edit their athlete schedules
	@RequestMapping("/edit")
	public String editAthlete() {
		return "editAthlete";
	}
	
	
	//Add new user to database
	@RequestMapping(value="/createAthlete", method=RequestMethod.GET)
	public String createUser(@RequestParam(value="id") String id, @RequestParam(value="email") String email, @RequestParam(value="name") String name) throws InterruptedException, ExecutionException {
		Integer newID = Integer.parseInt(id);
		UserDTO newUser = new UserDTO(newID, email, name);
		firebaseService.saveUserDeatails(newUser);
		return "index";
	}
	
}
