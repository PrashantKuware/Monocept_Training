package com.monocept.demo;

public class Student 
{
	private int rollno;
	private String name;
	private Address address;
	
	public int getRollno() 
	{
		return rollno;
	}
	
	public void setRollno(int rollno) 
	{
		this.rollno = rollno;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Address getAddress() 
	{
		return address;
	}
	
	public void setAddress(Address address) 
	{
		this.address = address;
	}
	
	public void display()
	{
		System.out.println("Roll No : "+rollno);
		System.out.println("Name : "+name);
		System.out.println("Address : "+address);
	}
	
	public String toString()
	{
		return "#"+address.getHouseno()+","+address.getCity()+"-"+address.getPincode();
	}
	
}
