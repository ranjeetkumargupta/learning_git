package com.wipro.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import com.wipro.model.User;
/*
* spring-rest-template application is a consumer application
* spring-boot-jpa application is producer application
*
* Consumer application makes calls to producer application through RestTemplate object
*/
@RestController
@RequestMapping("/cc")
public class UserConsumerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/users/{userid}")
	public ResponseEntity<User> consumeUserById(@PathVariable(value="userid" )Integer userid){
		//API end-point of producer application
		final String uri = "http://localhost:9091/api/v1/users/{userid}";	  
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("userid", userid);
			User user =
					restTemplate.getForObject(uri, User.class, params);
			System.out.println(user);
			return  new ResponseEntity<>(user,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> consumeAllUsers(){
		//API end-point of producer application
		final String uri = "http://localhost:9091/api/v1/users";	  
		try {
			
			
			ResponseEntity<List<User>> response = restTemplate
				       .exchange(uri, HttpMethod.GET, null,  new ParameterizedTypeReference<List<User>>() {});
			
			
			
			return  response;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<User> sendUser(@RequestBody User user){
		final String uri = "http://localhost:9091/api/v1/users";	  
		try {
	
			ResponseEntity<User> response = restTemplate.postForEntity(uri, user, User.class);
			
			return  response;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		final String uri = "http://localhost:9091/api/v1/users";	  
		try {
	
//			 restTemplate.put(uri, user);
			
			HttpEntity<User> request = new HttpEntity<User>(user);
			
			ResponseEntity<User> response = restTemplate
				       .exchange(uri, HttpMethod.PUT, request,new ParameterizedTypeReference<User>() {});
			
			return response;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	//http://localhost:9092/cc/users/1
	@DeleteMapping("/users/{userid}")
	public ResponseEntity<User> deleteUser(@PathVariable(value="userid") Integer userid){
		final String uri = "http://localhost:9091/api/v1/users/{userid}";	  
		
		try {
	
			Map<String, Integer> params = new HashMap<>();
			params.put("userid", userid);
			ResponseEntity<User> user = this.consumeUserById(userid);
			
			restTemplate.delete(uri, params);
			
			return user;
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
}






