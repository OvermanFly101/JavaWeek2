package com.flynn.dojoNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.flynn.dojoNinjas.models.Dojo;
import com.flynn.dojoNinjas.models.Ninja;
import com.flynn.dojoNinjas.services.MainService;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@GetMapping("/dojo/new")
	public String index(@ModelAttribute("dojo")Dojo dojo) {
		return "addDojo.jsp";
	}
	
	@PostMapping("/dojo/new")
	public String processNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "addDojo.jsp";
		}else {
			mainService.saveDojo(dojo);
			return "addDojo.jsp";
		}
	}
	
	@GetMapping("/ninja/new")
	public String addNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> dojo = mainService.allDojos();
		model.addAttribute("dojo", dojo);
		return "addNinja.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String processNewNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojo = mainService.allDojos();
			model.addAttribute("dojo", dojo);
			return "addNinja.jsp";
		}else {
			mainService.saveNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String dojoView(@PathVariable("id") Long id, Model model) {
		Dojo dojo = mainService.oneDojo(id);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}

	
}
