package com.coding.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.dojosninjas.models.Dojo;
import com.coding.dojosninjas.services.DojoService;
import com.coding.dojosninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newDojo") Dojo newDojo) {
		
		return "createDojo.jsp";
	}
	
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("newDojo") Dojo newDojo, BindingResult result) {
		if(result.hasErrors()) {
			return "createDojo.jsp";
		}else {
			dojoService.createDojo(newDojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojo/show/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.oneDojo(id));
//		model.addAttribute("allNinjas", ninjaService.allNinjas());
		
		
		return "displayLocation.jsp";
	}
}
