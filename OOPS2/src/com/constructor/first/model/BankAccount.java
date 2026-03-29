package com.constructor.first.model;

public class BankAccount 
{

    private static int counter = 1001;   

    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    private static double interestRate = 5.0;


    // 🔹 Constructor (default balance 0)
    public BankAccount(String accountHolderName) {
        this(accountHolderName, 0.0);
    }

    // 🔹 Constructor (with balance)
    public BankAccount(String accountHolderName, double balance) {

        this.accountNumber = "ACC" + counter++;
        this.accountHolderName = accountHolderName;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
            System.out.println("Invalid balance. Defaulted to 0.");
        }
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account No: " + accountNumber +
                "\nHolder: " + accountHolderName +
                "\nBalance: ₹" + balance +
                "\nInterest Rate: " + interestRate + "%";
    }
}
