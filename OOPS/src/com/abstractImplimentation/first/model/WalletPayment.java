package com.abstractImplimentation.first.model;

public class WalletPayment extends Payment
{
	public WalletPayment(double amount)
	{
		super(amount);
	}
	@Override
	public void processPayment()
	{
		validateAmount();
		
		double fee = amount*0.01;
		 total = amount+fee;
		
		 System.out.println("Processing Wallet Payment...");
	        System.out.println("Processing Fee (1%): ₹" + fee);
	        System.out.println("Total Deducted: ₹" + total);
	}
	
	@Override
	 public void generateReceipt() {
        System.out.println("Receipt Generated");
//        System.out.println("Amount Paid: ₹" + total);
        System.out.println("Thank you for using Wallet!");
        System.out.println("----------------------------");
    }
}
