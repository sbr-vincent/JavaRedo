package com.coding.parameters;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/")
	public String index(@RequestParam(value = "name", required = false) String searchQuery, @RequestParam(value = "last_name", required = false) String searchQuery2) {
		if(searchQuery == null && searchQuery2 == null) {
			return "Hello Human";			
		}else {			
			return "Hello " + searchQuery + " " + searchQuery2;
		}
	}
}
