package com.wipro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uc")
public class UserController {
	
	@RequestMapping("/hello")
	public String check() {
		return "Hello How are you?";
	}

}
