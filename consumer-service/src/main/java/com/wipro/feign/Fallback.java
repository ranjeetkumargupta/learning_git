package com.wipro.feign;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.wipro.model.User;

@Component
public class Fallback implements FeignService{

	@Override
	public String consumeGreeting() {
		
		return "Currently the service is down";
	}

	@Override
	public User postUser(User user) {
		return new User(null, "service is down",null,LocalDateTime.now());
		
	}

	
	
	
	
}
