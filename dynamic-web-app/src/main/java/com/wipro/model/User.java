package com.wipro.model;

import java.time.LocalDate;

public class User {
	
	
	private String userId;
	private String password;
	
	private LocalDate birth;
	
	public User(String userId, String password, LocalDate birth) {
		super();
		this.userId = userId;
		this.password = password;
		this.birth = birth;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", birth=" + birth + "]";
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
	
	
	
	

}
