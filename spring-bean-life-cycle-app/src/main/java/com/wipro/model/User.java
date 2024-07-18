package com.wipro.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class User {
	private String userid;
	private String password;
	
	
	public User() {
		
	}


	public User(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + "]";
	}
	
	
	public void customInitialize() {
		System.out.println("customInitialize() method executed");
	}
	
	public void customDestroy() {
		System.out.println("customDestroy() method is executed");
	}
	
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct() method is executed");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy() method is executed");
	}
}


