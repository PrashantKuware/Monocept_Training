package com.abstractImplimentation.first.model;

public abstract class Payment 
{
	protected double amount;
	protected double total;
	
	public Payment(double amount)
	{
		this.amount = amount;
	}
	
	public void validateAmount()
	{
		if(amount <= 0)
		{
			System.out.println("Please enter valid number or greater than 0");
		}
	}
	
	public abstract void processPayment();
	
	public void generateReceipt()
	{
		System.out.println("Receipt Generated");
//        System.out.println("Amount Paid: ₹" + total);
        System.out.println("----------------------------");
	}
}
