package com.vinceguerena.logindemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vinceguerena.logindemo.models.LoginUser;
import com.vinceguerena.logindemo.models.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session){
        //! TO-DO call a register method in the service
        // ! Some extra valdations and create a new user
        if(result.hasErrors()){
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }

        // ! TO-DO later: Store their ID from the DB in session

        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
        // !Add once service is implemented: 
        // User user = userServ.login(newLogin, result);

        if(result.hasErrors()){
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }

        // !TO-DO: Store their id from the DB in session

        return "redirect:/home";

    }














}
