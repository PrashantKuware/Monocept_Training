package com.Interface.BankingDomain.model;



public class LoanAccount implements AccountOperations 
{

    private int accountId;
    private double balance;

    public LoanAccount(int accountId, double loanAmount) 
    {
        this.accountId = accountId;
        this.balance = -loanAmount;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Loan repayment successful.");
    }

    @Override
    public void withdraw(double amount) 
    {
        balance -= amount;
        System.out.println("Loan amount increased.");
    }

    @Override
    public void checkBalance() 
    {
        System.out.println("Loan Account Balance: ₹" + balance);
    }

    @Override
    public int getAccountId() 
    {
        return accountId;
    }

    @Override
    public String getAccountType() 
    {
        return "Loan";
    }
}