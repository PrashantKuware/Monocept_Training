package com.constructor.first.model;

public class PremiumAccount extends BankAccount {

    private static final double BONUS = 1000;

    public PremiumAccount(String accountHolderName, double balance) {
        super(accountHolderName, balance + BONUS);
    }

    public PremiumAccount(String accountHolderName) {
        super(accountHolderName, BONUS);
    }
}
