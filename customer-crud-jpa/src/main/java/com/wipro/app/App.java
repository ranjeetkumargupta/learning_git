package com.wipro.app;

import java.util.Iterator;
import java.util.List;

import com.wipro.entity.Customer;
import com.wipro.service.CustomerService;
import com.wipro.service.CustomerServiceImpl;

public class App {
	
	private static CustomerService service  = new CustomerServiceImpl();
	
	
	public static void main(String[] args) {
	service.addCustomer(new Customer(null,"pra","pra@gmail.com",7906756900l));
	service.addCustomer(new Customer(null,"om","om@gmail.com",8907856910l));
		
		Customer customer1 = service.getCustomerById(1);
		System.out.println(customer1);
		
		Customer customer2 = service.getCustomerById(2);
		System.out.println(customer2);
		
		List<Customer> customerList = service.getAllCustomers();
		Iterator<Customer> iterator = customerList.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
		Customer customer1 = service.getCustomerById(1);
		System.out.println("Befor : " + customer1);
		customer1.setEmail("charu@gmail.com");
		
		String status = service.updateCustomer(customer1);
		System.out.println(status);
		
		customer1 = service.getCustomerById(1);
		System.out.println("After : "+ customer1);
		
		String status = service.deleteCustomer(2);
		System.out.println(status);
		
		List<Customer> customerList = service.getAllCustomers();
		Iterator<Customer> iterator = customerList.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
	}

}
