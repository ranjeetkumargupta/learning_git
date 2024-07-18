package com.wipro.app;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.model.Address;
import com.wipro.model.Employee;

/**
 * Hello world!
 *
 */
public class App {


	public static void main(String[] args) {
		ApplicationContext context=null;
		try {
			//IoC container 			
			context= new ClassPathXmlApplicationContext("spring2.xml");
			
			
			
			Employee employee=(Employee)context.getBean("em1");
			
			//List<Address>list=employee.getAddress().stream().filter(c->c.getCity().equals("xyz")).filter(c->c.getStreet().startsWith("a")).collect(Collectors.toList());
			System.out.println(employee);
			
			Employee employee1=(Employee)context.getBean("em1");
			
			System.out.println(employee1);
			
			
			 //shutdown IoC 
			((AbstractApplicationContext)context).registerShutdownHook();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			((AbstractApplicationContext)context).close();
		}


	}


}

