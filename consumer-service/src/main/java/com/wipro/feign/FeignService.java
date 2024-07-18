package com.wipro.feign;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.wipro.model.User;

@FeignClient(name = "producer-service", fallback = Fallback.class)
public interface FeignService {

	@GetMapping("/gc/greet")
	public String consumeGreeting();
	
	@PostMapping("/gc/user")
	public User postUser(@RequestBody User user);
}
