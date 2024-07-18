package com.wipro.model;

import java.time.LocalDate;
import java.util.List;

public class Employee {
	
	private Integer empo;
	private String ename;
	
	
	private List<Address> address;


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Employee(Integer empo, String ename, List<Address> address) {
		super();
		this.empo = empo;
		this.ename = ename;
		this.address = address;
	}





	public Integer getEmpo() {
		return empo;
	}


	public void setEmpo(Integer empo) {
		this.empo = empo;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	


	public List<Address> getAddress() {
		return address;
	}





	public void setAddress(List<Address> address) {
		this.address = address;
	}





//	@Override
//	public String toString() {
//		return "Employee [empo=" + empo + ", ename=" + ename + ", address=" + address + "]";
//	}





	

}
