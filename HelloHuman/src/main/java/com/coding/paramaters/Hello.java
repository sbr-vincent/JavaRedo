package com.coding.paramaters;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false) String searchQuery) {
		System.out.println(searchQuery);
		return "Hello Human";
	}
}
