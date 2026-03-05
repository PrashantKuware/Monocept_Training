package com.Interface.BankingDomain.model;


public class CurrentAccount implements AccountOperations {

    private int accountId;
    private double balance;

    public CurrentAccount(int accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } 
        else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } 
        else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Account Balance: ₹" + balance);
    }

    @Override
    public int getAccountId() {
        return accountId;
    }

    @Override
    public String getAccountType() {
        return "Current";
    }
}