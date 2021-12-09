package com.flynn.ninjaGold;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		
		session.setAttribute("activities", new ArrayList<String>());
		return "index.jsp";
	}
	
	@RequestMapping("/clickGold")
	public String clickGold(@RequestParam(value="location") String location, HttpSession session) {
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		
		//Gives a random of gold to be find in each location
		int min;
		int max;
		//Goes through locations and checks which location we are collecting gold
		if("farm".equals(location)) {
			min = 10;
			max = 20;
			int randomInt = (int) Math.floor(Math.random() * (max-min+1) + min);
			
			//add gold to purse
			if(session.getAttribute("treasure") == null) {
				session.setAttribute("treasure", 0);
			}else {
				Integer treasure = (Integer) session.getAttribute("treasure");
				session.setAttribute("treasure", treasure+randomInt);
				
				activities.add("You entered a farm and earned " + randomInt + " gold.");
				session.setAttribute("activities", activities);
			}
			System.out.println("Collect (Farm): "+ randomInt);
		}else if("cave".equals(location)) {
			min = 5;
			max = 10;
			int randomInt = (int) Math.floor(Math.random() * (max-min+1) + min);
			
			//add gold to purse
			if(session.getAttribute("treasure") == null) {
				session.setAttribute("treasure", 0);
			}else {
				Integer treasure = (Integer) session.getAttribute("treasure");
				session.setAttribute("treasure", treasure+randomInt);
				
				activities.add("You entered a Cave and earned " + randomInt + " gold.");
				session.setAttribute("activities", activities);
			}
			System.out.println("Collect (Cave): "+ randomInt);
		}else if("house".equals(location)) {
			min = 2;
			max = 5;
			int randomInt = (int) Math.floor(Math.random() * (max-min+1) + min);
			
			//add gold to purse
			if(session.getAttribute("treasure") == null) {
				session.setAttribute("treasure", 0);
			}else {
				Integer treasure = (Integer) session.getAttribute("treasure");
				session.setAttribute("treasure", treasure+randomInt);
				
				activities.add("You entered a house and earned " + randomInt + " gold.");
				session.setAttribute("activities", activities);
			}
			System.out.println("Collect (House): "+ randomInt);
		}else if("casino".equals(location)) {
			min = 0;
			max = 50;
			int randomInt = (int) Math.floor(Math.random() * (max-min+1) + min);
			
			//test luck
			Random rand = new Random();
			boolean luckyOrNot = rand.nextBoolean();
			
			
			if(luckyOrNot == true) {
				if(session.getAttribute("treasure") == null) {
					session.setAttribute("treasure", 0);
				}else {
					Integer treasure = (Integer) session.getAttribute("treasure");
					session.setAttribute("treasure", treasure+randomInt);
					
					activities.add("You entered a casino and earned " + randomInt + " gold.");
					session.setAttribute("activities", activities);
				}
				System.out.println("Collect (casino): "+ randomInt);
			}else {
				if(session.getAttribute("treasure") == null) {
					session.setAttribute("treasure", 0);
				}else {
					Integer treasure = (Integer) session.getAttribute("treasure");
					session.setAttribute("treasure", treasure-randomInt);
					
					activities.add("You entered a casino and lost " + randomInt + " gold. Ouch.");
					session.setAttribute("activities", activities);
				}
				System.out.println("Lost (casino): "+ randomInt);
			}
		}else {
			System.out.println("No gold. Where did you go?");
		}
		
		
		return "redirect:/";
	}
	
	@RequestMapping("/clickGold/casino")
	public String getCasinoGold() {
		int min = 0;
		int max = 50;
		int randomInt = (int) Math.floor(Math.random() * (max-min+1) + min);
		
		//test luck
		Random rand = new Random();
		boolean luckyOrNot = rand.nextBoolean();
		
		Gold gamble = new Gold();
		
		if(luckyOrNot == true) {
			gamble.addGold(randomInt);
		}else {
			gamble.subtractGold(randomInt);
		}
		return "redirect:/";
	}
}
