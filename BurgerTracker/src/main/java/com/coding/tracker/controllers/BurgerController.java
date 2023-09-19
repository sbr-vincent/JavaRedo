package com.coding.tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.coding.tracker.models.Burger;
import com.coding.tracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	private BurgerService burgerService;

	@GetMapping("/")
	public String index(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		
		return "index.jsp";
	}
	
	@PostMapping("/burger/create")
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			burgerService.createBurger(burger);
			return "redirect:/";
		}
	}
	
	@GetMapping("/burger/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerService.findBurger(id);
		
		model.addAttribute(burger);
		return "editBurger.jsp";
	}
	
	@PutMapping("/burger/update/{id}")
	public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if(result.hasErrors()) {
			return "editBurger.jsp";
		}else {
			burgerService.updateBurger(burger);
			return "redirect:/";
		}
	}
	
	
	
	
	
}
