package com.wipro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.model.User;


@Controller
@RequestMapping("/lc")
public class Login {
	
	
	@RequestMapping("/loginCheck")
	public String greet(@ModelAttribute User user, Model m) {
		
		
		if(!user.getUsername().equals(user.getPassword())) {
			m.addAttribute("user",user);
			return "greetLogin";
		}
		
		return "error";
		
		
	}
	
	@RequestMapping("/login")
	public String sayHello(@RequestParam(value="name",required=false) String name,Model model) {
		model.addAttribute("user",new User());
		return "login";
	}
	

}
