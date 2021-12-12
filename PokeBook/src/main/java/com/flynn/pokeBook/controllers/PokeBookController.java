package com.flynn.pokeBook.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;

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
	
	@GetMapping("/poke/{id}/edit")
	public String editOnePoke(@PathVariable("id") Long id, Model model) {
		PokeBook poke = pokeService.findPoke(id);
		model.addAttribute("poke", poke);
		return "editForm.jsp";
	}
	
	@PutMapping("/poke/{id}/edit")
	public String processEdit(@Valid @ModelAttribute("poke") PokeBook poke, BindingResult result, @PathVariable("id") Long id ) {
		if(result.hasErrors()) {
			return "editForm.jsp";
		}else {
			pokeService.editModelPoke(poke);
			return "redirect:/pokebook";
		}		
	}
	
}
