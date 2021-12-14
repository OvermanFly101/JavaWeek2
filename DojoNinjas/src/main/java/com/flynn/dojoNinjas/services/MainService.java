package com.flynn.dojoNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flynn.dojoNinjas.models.Dojo;
import com.flynn.dojoNinjas.models.Ninja;
import com.flynn.dojoNinjas.repositories.DojoRepository;
import com.flynn.dojoNinjas.repositories.NinjaRepository;

@Service
public class MainService {
	
	//Option 1:
//	private DojoRepository dojoRepo;
//	private NinjaRepository ninjaRepo;
//	
//	public MainService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
//		this.dojoRepo = dojoRepo;
//		this.ninjaRepo = ninjaRepo;
//	}
	
	//Option 2: Same as option 1 but short.
	@Autowired
	DojoRepository dojoRepo;
	
	@Autowired
	NinjaRepository ninjaRepo;
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionDojo = dojoRepo.findById(id);
		if(optionDojo.isPresent()) {
			return optionDojo.get();
		}else {
			return null;
		}
	}
	
	public Dojo saveDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
