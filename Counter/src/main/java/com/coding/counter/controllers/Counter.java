package com.coding.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Counter {
	@RequestMapping("/")
	public String index(HttpSession	session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
			int counter = (int) session.getAttribute("count") + 1;
			session.setAttribute("count", counter);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String visit(HttpSession	session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		return "visit.jsp";
	}
}
