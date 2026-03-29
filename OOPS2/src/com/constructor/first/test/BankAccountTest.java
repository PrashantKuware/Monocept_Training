package com.constructor.first.test;

import java.util.Scanner;

import com.constructor.first.model.BankAccount;
import com.constructor.first.model.PremiumAccount;

public class BankAccountTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Account Holder Name:");
        String name = scanner.nextLine();

        double balance;

        while (true) {

            System.out.println("Enter Initial Balance:");

            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Enter numeric value.");
                scanner.nextLine();
                continue;
            }

            balance = scanner.nextDouble();
            scanner.nextLine();

            if (balance < 0) {
                System.out.println("Balance cannot be negative.");
                continue;
            }

            break;
        }

        System.out.println("Press 1 for Normal Account");
        System.out.println("Press 2 for Premium Account");

        int choice = scanner.nextInt();

        BankAccount account;

        if (choice == 2) {
            account = new PremiumAccount(name, balance);
        } else {
            account = new BankAccount(name, balance);
        }

        System.out.println("\nAccount Created Successfully!");
        System.out.println(account);

        scanner.close();
    }
}
