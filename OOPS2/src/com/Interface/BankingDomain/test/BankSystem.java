package com.Interface.BankingDomain.test;

import java.util.Scanner;
import com.Interface.BankingDomain.model.*;


public class BankSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of accounts: ");
        int count = Integer.parseInt(scanner.nextLine());

        AccountOperations[] accounts = new AccountOperations[count];

        for (int i = 0; i < count; i++) {

            System.out.println("Select Account Type (1-Savings, 2-Current, 3-Loan): ");
            int choice = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter initial amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            int accountId = i + 1;

            switch (choice) {
                case 1:
                    accounts[i] = new SavingsAccount(accountId, amount);
                    break;
                case 2:
                    accounts[i] = new CurrentAccount(accountId, amount);
                    break;
                case 3:
                    accounts[i] = new LoanAccount(accountId, amount);
                    break;
            }
        }

        
        while (true) {

            System.out.println("Choose Account ID to operate (1 to " + count + ") or 0 to Exit:");
            int id = Integer.parseInt(scanner.nextLine());

            if (id == 0)
                break;

            AccountOperations selected = accounts[id - 1];

            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");

            int op = Integer.parseInt(scanner.nextLine());

            if (op == 1) {
                System.out.print("Enter deposit amount: ");
                double amt = Double.parseDouble(scanner.nextLine());
                selected.deposit(amt);
            } else if (op == 2) {
                System.out.print("Enter withdraw amount: ");
                double amt = Double.parseDouble(scanner.nextLine());
                selected.withdraw(amt);
            } else {
                selected.checkBalance();
            }
        }

        
        System.out.println("===== FINAL ACCOUNT STATUS =====");

        for (AccountOperations acc : accounts) {
            System.out.println("Account ID: " + acc.getAccountId()
                    + " | Type: " + acc.getAccountType());
            acc.checkBalance();
            System.out.println("---------------------");
        }

        scanner.close();
    }
}