package com.wipro.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.model.User;
import com.wipro.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/uc")
//@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//http://localhost:9090/uc/users/user1
	@GetMapping("/users/{username}")
	public User getUserByName( @PathVariable(value = "username") String username) throws Exception{
		try {
			User user = userService.getUserByName(username);
			if(user ==null ) {
				throw new Exception("Invalid Username");
			}
			//log.info(user.getUsername()+" "+user.getPassword());
			
			return user;
		}catch(Exception e) {
			//log.error(e.getMessage());
			throw e;
		}
	}
	
	//http://localhost:9090/uc/users
	
	@GetMapping("/users")
	public List<User> getAllUsers() throws Exception{
		try {
			List<User> userList = userService.getAllUsers();
			if(userList.size() == 0 ) {
				throw new Exception("User List is empty");
			}
			
			return userList;
		}catch(Exception e) {
			throw e;
		}
	}
	
	//http://localhost:9090/uc/users
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		User newUser = userService.addUser(user);
		return newUser;
	}
	
	@PutMapping("/users")
	public User updateUserPassword(@RequestBody User user) {
		return userService.updateUserPassword(user);
	}
	
	
	//http://localhost:9090/uc/users?username=user1
	
	@DeleteMapping("/users")
	public String deleteUser(@RequestParam(value = "username") String username) {
		return userService.deleteUser(username);
	}
	
	
}
