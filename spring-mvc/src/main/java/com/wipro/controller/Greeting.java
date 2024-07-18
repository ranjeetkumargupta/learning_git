package com.wipro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Greeting {
	
	
	@RequestMapping("/greet")
	public String greet(Model m) {
		
		m.addAttribute("userId","Srini");
		m.addAttribute("role", "Trainer");
		return "greeting";
	}
	
	@RequestMapping("/hello")
	public String sayHello(@RequestParam(value="name",required=false) String name,Model model) {
		model.addAttribute("name",name);
		return "hello";
	}

}
