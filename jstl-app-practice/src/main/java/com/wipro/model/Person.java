package com.wipro.model;
public class Person {
	private Long adharCard;
	private String firstName;
	private String lastName;
	private String address;
	private Long mobile;
	
	
	public Person() {
		
	}
	public Person(Long adharCard, String firstName, String lastName, String address, Long mobile) {
		super();
		this.adharCard = adharCard;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.mobile = mobile;
	}
	public Long getAdharCard() {
		return adharCard;
	}
	public void setAdharCard(Long adharCard) {
		this.adharCard = adharCard;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Person [adharCard=" + adharCard + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", mobile=" + mobile + "]";
	}
	
	
	
}
