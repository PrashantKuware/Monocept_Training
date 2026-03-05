


import java.io.*;

class Account
{
    
    private String accountHolder;
    private double balance;

    
    public String getAccountHolder()
    {
        return accountHolder;
    }

    
    public void setAccountHolder(String accountHolder)
    {
        this.accountHolder = accountHolder;
    }

    public double getBalance()
    {
        return balance;
    }

   
    public void deposit(double amount)
    {
        
        if (amount > 0)
        {
            balance = balance + amount;
            System.out.println("You have deposited " + amount + " Rs.");
            System.out.println("New balance is: " + getBalance() + " Rs.");
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
            System.out.println("You have withdrawn " + amount + " Rs.");
            System.out.println("New balance is: " + getBalance() + " Rs.");
        }
        else
        {
            System.out.println("Invalid or Insufficient balance for withdrawal");
        }
    }
}

 class encapsulationExample
{
    public static void main(String[] args)
    {
        
        Account account = new Account();
        
        account.setAccountHolder("Deepak");

        
        account.deposit(10000);      
        account.withdraw(3000);     

        account.deposit(-20000);    
        account.withdraw(100000);    
    }
}