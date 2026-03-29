package com.abstractImplimentation.first.model;

public class CreditCardPayment extends Payment 
{
	public CreditCardPayment(double amount) 
	{
		super(amount);
	}

	public void processPayment() 
	{
		validateAmount();
		double fee = amount * 0.2;
		double total = amount + fee;

		System.out.println("Processing Credit Card Payment...");
		System.out.println("Processing Fee (2%): ₹" + fee);
		System.out.println("Total Deducted: ₹" + total);
	}

}
