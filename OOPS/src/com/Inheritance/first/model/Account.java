package com.Inheritance.first.model;

public abstract class Account {


	  private static int counter = 1001;

	    protected String accountNumber;
	    protected String holderName;
	    protected double balance;

	    public Account(String holderName, double balance) {
	        this.accountNumber = "ACC" + counter++;
	        this.holderName = holderName;
	        this.balance = balance;
	    }

	    public void deposit(double amount) {
	        if (amount <= 0) {
	            System.out.println("Invalid deposit amount");
	            return;
	        }

	        balance += amount;
	        System.out.println("Deposited: " + amount);
	    }

	    public void displayDetails() {
	        System.out.println("\nAccount Number : " + accountNumber);
	        System.out.println("Holder Name    : " + holderName);
	        System.out.println("Balance        : " + balance);
	    }

	    public abstract void withdraw(double amount);

}
