package com.encapsulation.first.model;

public class Account_Data {

	String ac_holder_name;
	private double balance;
	private static long counter = 145344028L;
	private final long accountNumber;
	
	public Account_Data() {
        this.accountNumber = generateAccountNumber();
        this.balance = 0;
    }
	private static synchronized long generateAccountNumber() {
        return counter++;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
	public void setAccountHolder(String accountHolder)
    {
        this.ac_holder_name = accountHolder;
    }
	
	public String getAccountHolder()
	{
		return ac_holder_name;
	}
	
	public double checkBalance()
    {
        return balance;
    }
	
	public void deposit(double amount)
    {
        
        if (amount > 0)
        {
            balance = balance + amount;
        }
        else
        {
            System.out.println("Invalid deposit amount");
        }
    }
	
	public void withdraw(double amount)
    {
      
        if (amount > 0 && amount <= balance)
        {
            balance = balance - amount;
            
        }
        else
        {
            System.out.println("Invalid or Insufficient balance for withdrawal");
        }
    }
}
