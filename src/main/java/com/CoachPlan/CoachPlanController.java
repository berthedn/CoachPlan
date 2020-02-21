package com.CoachPlan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoachPlanController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/athlete")
	public String athletePage() {
		return "athlete";
	}
	
	@RequestMapping("/athleteList")
	public String athleteList() {
		return "athleteList";
	}
	
	@RequestMapping("/edit")
	public String editAthlete() {
		return "editAthlete";
	}
	
}
