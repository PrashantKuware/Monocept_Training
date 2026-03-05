package com.Inheritance.first.model;

public class SavingsAccount extends Account {

    private double minBalance = 1000;

    public SavingsAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return;
        }

        if (balance - amount < minBalance) {
            System.out.println("Withdrawal denied. Minimum balance must be maintained (1000).");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }
}
