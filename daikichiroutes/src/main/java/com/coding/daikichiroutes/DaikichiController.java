package com.coding.daikichiroutes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/daikichi")
public class DaikichiController {

	@RequestMapping("")
	public String index() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!.";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("/travel/{city}")
	public String travel(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to "
				+ city;
	}
	
	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable("number") Integer number) {
		if(number % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}
	
	@GetMapping("/omikuji")
	public String omikuji() {
		
		return "index.jsp";
	}
	
	@PostMapping("/omikuji/form")
	public String submission(@RequestParam(value="number") String number,@RequestParam(value="city") String city,@RequestParam(value="name") String name,@RequestParam(value="hobby") String hobby,@RequestParam(value="creature") String creature,@RequestParam(value="comment") String comment, HttpSession session) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("creature", creature);
		session.setAttribute("comment", comment);
		
		return "redirect:/daikichi/omikuji/display";
	}
	
	@GetMapping("/omikuji/display")
	public String display(Model model, HttpSession session) {
//		model.addAttribute("number", session.getAttribute("number"));
//		model.addAttribute("city", session.getAttribute("city"));
//		model.addAttribute("name", session.getAttribute("name"));
//		model.addAttribute("hobby", session.getAttribute("hobby"));
//		model.addAttribute("creature", session.getAttribute("creature"));
//		model.addAttribute("comment", session.getAttribute("comment"));
		
		return "display.jsp";
	}
}













