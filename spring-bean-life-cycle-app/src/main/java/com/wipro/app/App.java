package com.wipro.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.model.User;



public class App {

	public static void main(String[] args) {
		ApplicationContext context=null;
		try {
			//IoC container 			
			context= new ClassPathXmlApplicationContext("spring.xml");
			
			User user = (User) context.getBean("userBean");
			
			System.out.println(user);
			
			 //shutdown IoC 
			((AbstractApplicationContext)context).registerShutdownHook();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			((AbstractApplicationContext)context).close();
		}

	}

}
