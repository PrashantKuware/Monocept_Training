package com.Interface.first.model;

public class UPIPayment implements Payment
{
	@Override
	public void processPayment(double amount)
	{
		if(amount <= 0)
		{
			System.out.println("Invalid Amount");
			return;
		}
		 	System.out.println("Processing UPI Payment...");
	        System.out.println("Amount: ₹" + amount);
	        System.out.println("No Processing Fee");
	        System.out.println("Total Deducted: ₹" + amount);
	}
}
