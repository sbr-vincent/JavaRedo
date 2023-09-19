package com.coding.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.dojosninjas.models.Ninja;
import com.coding.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
//	Find all
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
//	Find one
	public Ninja oneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}else {
			return null;
		}
	}
	
//	Create a ninja
	public Ninja creatNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
