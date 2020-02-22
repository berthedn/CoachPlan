package com.CoachPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CoachPlan.dto.CoachDTO;
import com.CoachPlan.service.ICoachService;

@Controller
public class CoachPlanController {
	
	//Need a service stub interface declared here. What should we call it? Will there be a separate one for coach and student? 
	//(Service stub will be used for backend database calls, think CRUD (create, read update, delete)). 
	//Also need to come up with a DTO class. Do we want to use different DTO classes for coach and student as well? 
	@Autowired
	private ICoachService coachServiceStub;
	
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
	
	//page for coaches to edit there athlete schedules
	@RequestMapping("/edit")
	public String editAthlete() {
		return "editAthlete";
	}
	
}
