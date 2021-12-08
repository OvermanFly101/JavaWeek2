package com.flynn.omikujiForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/processFortune")
	public String processFortune(
		@RequestParam(value="number") String number,
		@RequestParam(value="city") String city, 
		@RequestParam(value="person") String person,
		@RequestParam(value="career") String career,
		@RequestParam(value="animal") String animal,
		@RequestParam(value="somethingNice") String somethingNice,
		Model model) {
		
		model.addAttribute("number", number);
		model.addAttribute("city", city);
		model.addAttribute("person", person);
		model.addAttribute("career", career);
		model.addAttribute("animal", animal);
		model.addAttribute("somethingNice", somethingNice);
	
		
		return "post.jsp";
	}
	
}
