package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.entity.Role;
import com.wipro.entity.User;
import com.wipro.exception.UserException;
import com.wipro.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
//allow any client application to access the API end-points of this RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	
	// Autowired byType, UserServiceImpl bean is injected
//	@Autowired
//	private UserService userService;
	
	
	// Autowired byName, UserServiceCrudImpl bean is injected
	@Autowired(required = false)
	@Qualifier(value = "userServiceBean")
	private UserService userService;

	//http://localhost:9091/api/v1/users/1
	@GetMapping("/users/{userid}")
	public ResponseEntity<User> getUserById( @PathVariable(value="userid") Integer userid) {
		try {
			User user = userService.getUserById(userid);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}

	/*
	 * {
        "userid": null,
        "username": "srini",
        "password": "srini@123",
        "email": "srini@gmail.com",
        "mobile": 9976567680,
        "role": "USER"
  		}
	 */
	//http://localhost:9091/api/v1/users
	/*
	 * Validate User object coming from the client before saving to database
	 */
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user, BindingResult bindingResult) {
		try {
			if(bindingResult.hasErrors()) {
				throw new UserException(bindingResult.getAllErrors().toString());
			}
			
			User newUser = userService.addUser(user);
			return new ResponseEntity<>(newUser,HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}


	//http://9091/api/v1/users
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> userList = userService.getAllUsers();
			return new ResponseEntity<>(userList,HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> updateUser( @Valid  @RequestBody User user, BindingResult bindingResult){
		try {
			if(bindingResult.hasErrors()) {
				throw new UserException(bindingResult.getAllErrors().toString());
			}
			
			User updatedUser = userService.updateUser(user);
			return new ResponseEntity<>(updatedUser,HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@DeleteMapping("/users/{userid}")
	public ResponseEntity<User> deleteUser( @PathVariable(value="userid") Integer userid) {
		try {
			User deletedUser = userService.deleteUser(userid);
			return new ResponseEntity<>(deletedUser, HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	
	//http://localhost:9091/api/v1/users/2/2/mobile
	@GetMapping("/users/{pageNumber}/{rows}/{sortBy}")
	public ResponseEntity<List<User>> getUsersByPages(@PathVariable(value="pageNumber") Integer pageNumber,
													  @PathVariable(value="rows") Integer rows, 
													  @PathVariable(value="sortBy") String sortBy
														){
		try {
			//internally page 1 is 0, index starts from 0
			List<User> userList = userService.getUsersByPages(pageNumber-1, rows,sortBy);
			return new ResponseEntity<>(userList,HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	//http://localhost:9091/api/v1/users/bulk/2/2/mobile
	
	@GetMapping("/users/bulk/{numberOfPages}/{pageSize}/{sortBy}")
	public ResponseEntity<List<User>> getUsersByPagesCount(@PathVariable(value="numberOfPages") Integer numberOfPages, 
			@PathVariable(value="pageSize") Integer pageSize, 
			@PathVariable(value="sortBy") String sortBy){
		try {
			//internally page 1 is 0, index starts from 0
			List<User> userList = userService.getUsersByPagesCount(numberOfPages, pageSize, sortBy);
			return new ResponseEntity<>(userList,HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	
	//http://localhost:9091/api/v1/users/sort/mobile
	@GetMapping("/users/sort/{sortBy}")
	public ResponseEntity<List<User>> getUsersSortedByField(@PathVariable(value="sortBy") String sortBy){
		try {
			
			List<User> userList = userService.getUsersSortedByField(sortBy);
			return new ResponseEntity<>(userList,HttpStatus.OK);
		}catch(UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
			
	
		//http://localhost:9091/users/find/{admin}")
		@GetMapping("/users/find/{username}")
		public ResponseEntity<User> findByUsername(@PathVariable(value="username") String username){
			try {
				
				User user = userService.findByUsername(username);
				return new ResponseEntity<>(user,HttpStatus.OK);
			}catch(UserException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
		}
		
		@GetMapping("/users/role/{role}")
		public ResponseEntity<List<User>> findUsersByRole(@PathVariable(value="role") String role) {
			Role myRole = null;
			try {
				//converting String to Enum
				if(role.equals("USER")) {
					myRole = Role.USER;
				} else if(role.equals("ADMIN")) {
					myRole = Role.ADMIN;
				}else {
					myRole = Role.GROUP;
				}
				List<User> userList = userService.findUsersByRole(myRole);
				return new ResponseEntity<>(userList,HttpStatus.OK);
			}catch(UserException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
		}

}
