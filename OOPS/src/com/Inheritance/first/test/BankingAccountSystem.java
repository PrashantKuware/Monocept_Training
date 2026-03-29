package com.Inheritance.first.test;

import java.util.Scanner;

public class BankingAccountSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Holder Name: ");
		String name = scanner.nextLine();

		System.out.print("Enter Initial Balance: ");
		double balance = scanner.nextDouble();

		String transactionContinue = "false";

		if (balance < 0) {
			System.out.println("Balance cannot be negative.");
			return;
		}

		do {
			System.out.println("Choose Account Type:");
			System.out.println("1. Savings Account");
			System.out.println("2. Current Account");

			int choice;

			Account account = null;

			while (true) {
				if (!scanner.hasNextInt()) {
					System.out.println("invalid input. Please enter 1 or 2");
					scanner.nextLine();
					continue;
				}
				choice = scanner.nextInt();
				scanner.nextLine();
				break;
			}

			switch (choice) {
			case 1:
				account = new SavingsAccount(name, balance);
				break;

			case 2:
				account = new CurrentAccount(name, balance);
				break;

			default:
				System.out.println("Invalid choice.");
				return;
			}

			account.displayDetails();

			System.out.println("What do you want ?");
			System.out.println("3 for Deposit");
			System.out.println("4 for Withdraw");

			int task;

			while (true) {
				if (!scanner.hasNextInt()) {
					System.out.println("invalid input. Please enter 3 or 4");
					scanner.nextLine();
					continue;
				}
				task = scanner.nextInt();
				scanner.nextLine();
				break;
			}
			switch (task) {
			case 3:
				while (true) {
					System.out.println("Enter the amount to deposit:");
					if (!scanner.hasNextInt()) {
						System.out.println("Invalid input. Please enter numeric value.");
						scanner.nextLine();
						continue;
					}
					double depositAmount = scanner.nextDouble();
					scanner.nextLine();
					if (depositAmount < 0) {
						System.out.println("Enter valid number (greater than 0).");
						continue;
					}
					account.deposit(depositAmount);
					break;
				}
				break;

			case 4:
				while (true) {
					System.out.println("Enter the amount to withdraw :");
					if (!scanner.hasNextInt()) {
						System.out.println("Invalid input. Please enter numeric value.");
						scanner.nextLine();
						continue;
					}

					double withdrawAmount = scanner.nextDouble();
					scanner.nextLine();

					if (withdrawAmount <= 0) {
						System.out.println("Enter valid number (greater than 0).");
						continue;
					}
					account.withdraw(withdrawAmount);
					break;
				}
				break;

			default:
				System.out.println("Invalid option selected.");
			}
			System.out.println("If you want to continue the transaction type yes");
			transactionContinue = scanner.nextLine();

		} while (transactionContinue.equalsIgnoreCase("yes"));
		System.out.println("Thank you for banking with us!");
		scanner.close();

	}
}
