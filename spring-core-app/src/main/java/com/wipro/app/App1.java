package com.wipro.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.config.SpringConfig;
import com.wipro.model.Person;

public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context=null;
		
		
		try {
		
		context=new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Person person=(Person)context.getBean("personBean");
		System.out.println(person);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
