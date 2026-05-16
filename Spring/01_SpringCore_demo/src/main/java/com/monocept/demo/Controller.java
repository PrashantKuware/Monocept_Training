package com.monocept.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller
{

	private Coach myCoach;
	
	@Autowired
	public void DemoController(Coach coach) 
	{

		this.myCoach = coach;
	}
	
//	public void setter(Coach mycoach)
//	{
//		coach = mycoach;
//	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {

		return myCoach.getDailyWorkout();
	}
}
