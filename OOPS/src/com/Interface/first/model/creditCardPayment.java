package com.Interface.first.model;

public class creditCardPayment implements Payment
{
	@Override
	public void processPayment(double amount)
	{
		if(amount <= 0)
		{
			System.out.println("Invalid amount");
			return;
		}
		
		double fee = amount * 0.02;
		double total = amount + fee;
		System.out.println("Processing Credit Card Payment ...");
		System.out.println("Amount : ₹" + amount);
		System.out.println("Processing Fees 2% :" + fee);
		System.out.println("Total Deducted Amount :" + total);
	}
}
