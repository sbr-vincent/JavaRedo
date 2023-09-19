package com.coding.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "demo.jsp";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "Class annotations are cool too!";
	}
}
