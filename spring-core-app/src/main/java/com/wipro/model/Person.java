package com.wipro.model;

public class Person {
	
	
	private Integer id;
	private String name;
	private String city;
	private Address address;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(Integer id, String name, String city, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
//	@Override
//	public String toString() {
//		return "Person [id=" + id + ", name=" + name + ", city=" + city + ", address=" + address + "]";
//	}
	

}
