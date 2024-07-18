package com.wipro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wipro.model.Address;
import com.wipro.model.Person;

@Configuration
public class SpringConfig {
	
	
	@Bean
	public Address addressBean1() {
		return new Address("Shivaij Nagar","Pune");
	}
	
	@Bean
	public Person personBean() {
		return new Person(101,"Prakash","Gorakhpur",addressBean1());
	}
	

}
