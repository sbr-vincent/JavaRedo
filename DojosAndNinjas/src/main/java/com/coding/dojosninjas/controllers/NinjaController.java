package com.coding.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.dojosninjas.models.Ninja;
import com.coding.dojosninjas.services.DojoService;
import com.coding.dojosninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaService;
	
	@Autowired 
	private DojoService dojoService;
	
	@GetMapping("/ninja/new")
	public String newNinja(@ModelAttribute("newNinja") Ninja ninja, Model model) {
		model.addAttribute("dojoList", dojoService.allDojo());
		
		return "createNinja.jsp";
	}
	
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("newNinja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojoList", dojoService.allDojo());
			return "createNinja.jsp";
		}else {
			ninjaService.creatNinja(ninja);
			return "redirect:/ninja/new";
		}
	}
}
