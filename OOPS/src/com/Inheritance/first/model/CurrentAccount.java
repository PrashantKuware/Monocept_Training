package com.Inheritance.first.model;

public class CurrentAccount extends Account {

    private double overdraftLimit = 3000;

    public CurrentAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return;
        }

        if (balance - amount < -overdraftLimit) {
            System.out.println("Withdrawal denied. Overdraft limit exceeded (3000).");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }
}
