package com.coding.register.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.register.models.LoginUser;
import com.coding.register.models.User;
import com.coding.register.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

//	import service
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String renderLogRegForm(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "logreg.jsp";
	}
	
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User registerUser = userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "logreg.jsp";
		}else {
			session.setAttribute("userId", registerUser.getId());
			session.setAttribute("userName", registerUser.getUserName());
			return "redirect:/welcome";
		}
	}
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User loggedUser = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "logreg.jsp";
		}else {
			session.setAttribute("userId", loggedUser.getId());
			session.setAttribute("userName", loggedUser.getUserName());
			return "redirect:/welcome";
		}
	}
	
	@GetMapping("/welcome")
	public String welcome(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "welcome.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	
}
