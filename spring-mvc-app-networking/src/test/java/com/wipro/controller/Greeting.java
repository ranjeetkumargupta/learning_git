package com.wipro.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Greeting {
	@RequestMapping("/greet")
	public String greet(Model model) {
		model.addAttribute("userid", "Srini");
		model.addAttribute("role", "Trainer");
		return "greeting";
	}
	
	
	//http://localhost:8081/spring-mvc-app/hi
	
	@RequestMapping("/hi")
	public ModelAndView hi() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("database", "Oracle");
//		mav.setViewName("hi");
//		return mav;
		
		return new ModelAndView("hi","database","Oracle");
	};
	
	
	//http://localhost:8081/spring-mvc-app/hello?name=Srini&pwd=srini123
	@RequestMapping("/hello")
	public String sayHello(@RequestParam(value = "name", required = false, defaultValue = "Admin") String name,
			
			@RequestParam(value = "pwd", required = false, defaultValue = "admin123") String pwd,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("pwd", pwd);
		return "hello";
	}
	
	//path variables
	//http://localhost:8081/spring-mvc-app/welcome/srini/admin
	
	@RequestMapping("/welcome/{user}/{role}")
	public String sayWelcome(@PathVariable(value = "user") String user, @PathVariable(value = "role") String role, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("role", role);
		return "welcome";
	}
	
	
}
