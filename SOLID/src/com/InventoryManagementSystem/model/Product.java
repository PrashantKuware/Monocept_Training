package com.InventoryManagementSystem.model;

public class Product 
{
	private String name;
	private int quantity;
	private double price;
	private int reorderMin; 
	private int reorderMax;
	private boolean isPerishable;
	
	public Product(String name, int quantity, double price, int reorderMin, int reorderMax, boolean isPerishable)
	{
		this.name = name;
		this.quantity=quantity;
		this.price=price;
		this.reorderMin=reorderMin;
		this.reorderMax=reorderMax;
		this.isPerishable=isPerishable;
	}
	
	public String getname()
	{
		return name;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity; 
	}
	
	public double getPrice()
	{
		return price;
	}
	public int getMinQuantity()
	{
		return reorderMin;
	}
	public int getMaxQuantity()
	{
		return reorderMax;
	}
	
	public boolean getProductType()
	{
		return isPerishable;
	}
	
}
