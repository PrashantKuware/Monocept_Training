package com.Interface.BankingDomain.model;



public class SavingsAccount implements AccountOperations {

    private int accountId;
    private double balance;
    private static final double LIMIT = 10000;

    public SavingsAccount(int accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited successfully.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > LIMIT) {
            System.out.println("Limit exceeded.");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Savings Account Balance: ₹" + balance);
    }

    @Override
    public int getAccountId() {
        return accountId;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}