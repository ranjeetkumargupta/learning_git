package com.wipro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.dao.CountryRepository;
import com.wipro.model.Country;

@SpringBootApplication
public class SpringBootPersistenceH2Application implements CommandLineRunner{
	
	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPersistenceH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Country country1 = new Country(null, "India");
		Country country2 = new Country(null, "USA");
		Country country3 = new Country(null, "England");
		
		countryRepository.save(country1);
		countryRepository.save(country2);
		countryRepository.save(country3);
		
	}

}
