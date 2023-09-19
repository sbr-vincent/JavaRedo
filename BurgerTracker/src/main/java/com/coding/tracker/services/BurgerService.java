package com.coding.tracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.tracker.models.Burger;
import com.coding.tracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	@Autowired
	private BurgerRepository burgerRepo;
//	Find all burgers
	public List<Burger> allBurgers(){
		return burgerRepo.findAll();
	}
	
//	Find One Burger
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepo.findById(id);
		
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		}else {
			return null;
		}
	}
	
//	Create
	public Burger createBurger(Burger burger) {
		return burgerRepo.save(burger);
	}
	
//	Delete
	public void deleteBurger(Long id) {
		burgerRepo.deleteById(id);
	}
	
//	Update
	public Burger updateBurger(Burger burger) {
		return burgerRepo.save(burger);
	}
	
	
	
	
	
}
