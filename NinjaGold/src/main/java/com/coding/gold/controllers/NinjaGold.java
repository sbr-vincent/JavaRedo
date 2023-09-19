package com.coding.gold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaGold {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			ArrayList<String> activityArray = new ArrayList<String>();
			session.setAttribute("count", 0);
			session.setAttribute("activities", activityArray);
		} else {
			int counter = (int) session.getAttribute("count");
			session.setAttribute("count", counter);
		}
		return "index.jsp";
	}

	@PostMapping("/submit")
	public String generate(@RequestParam(value = "type") String type, HttpSession session) {

		Random randMachine = new Random();
		int updateCount = 0;
		int randomCoin = 0;
		ArrayList<String> activityInfo = new ArrayList<String>();;
		switch (type) {
		case "farm":
			randomCoin = randMachine.nextInt(21 - 10) + 10;
			updateCount = (int) session.getAttribute("count") + randomCoin;
			activityInfo = (ArrayList<String>) session.getAttribute("activities");
			activityInfo.add(String.format("You entered a farm and earned %s gold (%s)", randomCoin, new Date()));

			session.setAttribute("count", updateCount);
			break;
		case "cave":
			randomCoin = randMachine.nextInt(11 - 5) + 5;
			updateCount = (int) session.getAttribute("count") + randomCoin;
			activityInfo = (ArrayList<String>) session.getAttribute("activities");
			activityInfo.add(String.format("You entered a cave and earned %s gold (%s)", randomCoin, new Date()));

			session.setAttribute("count", updateCount);
			break;
		case "house":
			randomCoin = randMachine.nextInt(5 - 2) + 2;
			updateCount = (int) session.getAttribute("count") + randomCoin;
			activityInfo = (ArrayList<String>) session.getAttribute("activities");
			activityInfo.add(String.format("You entered a house and earned %s gold (%s)", randomCoin, new Date()));

			session.setAttribute("count", updateCount);
			break;
		case "quest":
			int luck = (randMachine.nextInt(2 - 0) + 0);
			
			if(luck == 1) {
				randomCoin = randMachine.nextInt(50 - 0) + 0;
				updateCount = (int) session.getAttribute("count") + randomCoin;
				activityInfo = (ArrayList<String>) session.getAttribute("activities");
				activityInfo.add(String.format("You entered a quest and earned %s gold (%s)", randomCoin, new Date()));
			}else {
				randomCoin = randMachine.nextInt(50 - 0) + 0;
				updateCount = (int) session.getAttribute("count") - randomCoin;
				activityInfo = (ArrayList<String>) session.getAttribute("activities");
				activityInfo.add(String.format("You entered a quest and lost %s gold. Ouch (%s)", randomCoin, new Date()));
			}

			session.setAttribute("count", updateCount);
			break;
		default:
			System.out.println("How did I get here!?");
		}

		return "redirect:/";
	}
}
