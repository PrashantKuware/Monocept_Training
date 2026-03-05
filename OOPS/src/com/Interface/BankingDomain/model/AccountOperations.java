package com.Interface.BankingDomain.model;


public interface AccountOperations {

    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();

    int getAccountId();
    String getAccountType();
}