package com.flynn.pokeBook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.flynn.pokeBook.models.PokeBook;
import com.flynn.pokeBook.services.PokeService;

@Controller
public class PokeBookController {
	@Autowired
	PokeService pokeService;
	
	@GetMapping("/pokebook")
	public String index(Model model, @ModelAttribute("pokeBook") PokeBook pokeBook){
		List<PokeBook> poke = pokeService.allPoke();
		model.addAttribute("pokes", poke);
		return "index.jsp";
	}
	
	@PostMapping("/createPoke")
	public String create(Model model, @Valid @ModelAttribute("pokeBook") PokeBook pokeBook, BindingResult result) {
		if(result.hasErrors()) {
			List<PokeBook> poke = pokeService.allPoke();
			model.addAttribute("pokes", poke);
			
			return "index.jsp";
		}else {
			pokeService.createPoke(pokeBook);
			return "redirect:/pokebook";
		}
	}
	
}
