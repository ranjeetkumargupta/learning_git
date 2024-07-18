package com.wipro;

public class Person {

	
	private Long adharId;
	private String name;
	private String address;
	private Long mobile;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Person [adharId=" + adharId + ", name=" + name + ", address=" + address + ", mobile=" + mobile + "]";
	}

	public Long getAdharId() {
		return adharId;
	}

	public void setAdharId(Long adharId) {
		this.adharId = adharId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Person(Long adharId, String name, String address, Long mobile) {
		super();
		this.adharId = adharId;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}
	
	
	
}
