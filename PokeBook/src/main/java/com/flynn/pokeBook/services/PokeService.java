package com.flynn.pokeBook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flynn.pokeBook.models.PokeBook;
import com.flynn.pokeBook.repositories.PokeRepository;

@Service
public class PokeService {
	
	private final PokeRepository pokeRepo;
	
	public PokeService(PokeRepository pokeRepo) {
		this.pokeRepo = pokeRepo;
	}
	
	public List<PokeBook> allPoke(){
		return pokeRepo.findAll();
	}
	
	public PokeBook createPoke(PokeBook pokeBook) {
		return pokeRepo.save(pokeBook);
	}
	
	public void deletePoke(Long id) {
		pokeRepo.deleteById(id);
	}
	
	public PokeBook findPoke(Long id) {
		Optional<PokeBook> optionalPoke = pokeRepo.findById(id);
		if(optionalPoke.isPresent()) {
			return optionalPoke.get();
		}else {
			return null;
		}
	}
}
