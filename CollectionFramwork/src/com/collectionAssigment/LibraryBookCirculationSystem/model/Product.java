package com.collectionAssigment.LibraryBookCirculationSystem.model;

public class Product 
{
	protected int id;
	protected String name;
	protected String author;
	public STATUS status;
	
	 public Product(int id, String name, String author)
	{
		this.id = id;
		this.author = author;
		this.name = name;
		this.status = STATUS.AVAILABLE;
	}
	 
	 public int getId()
	 {
		 return id;
	 }
	 public String getName()
	 {
		 return name;
	 }
	 
	 
	 public String toString() {
	        return "Product { ID: " + id +
	                ", Book Name: " + name +
	                ", Author: " + author + " Category : "+ this.getClass().getSimpleName() + ", Status : "+ status+" }";
	    }
}
