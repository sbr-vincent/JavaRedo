package com.coding.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.dojosninjas.models.Dojo;
import com.coding.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
//	Find all
	public List<Dojo> allDojo(){
		return dojoRepo.findAll();
	}
	
//	Find one
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
	
//	Create a dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
}
