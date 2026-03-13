package assignment1.AccountManagementSystem;

import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Account[] accounts = new Account[5];

        int count = 0;

        while (count < accounts.length) {

            int accNumber;
            String name;
            double balance;

            while (true) {

                System.out.print("Enter Account Number (4 digits): ");
                String input = scanner.nextLine();

                if (input.matches("\\d{4}")) {
                    accNumber = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Invalid Account Number");
                }
            }

            while (true) {

                System.out.print("Enter Account Holder Name: ");
                name = scanner.nextLine().trim();

                if (name.matches("[a-zA-Z ]{3,30}")) {
                    break;
                } else {
                    System.out.println("Invalid name");
                }
            }

            while (true) {

                System.out.print("Enter Initial Balance: ");
                String input = scanner.nextLine();

                if (input.matches("\\d+(\\.\\d{1,2})?")) {
                    balance = Double.parseDouble(input);
                    break;
                } else {
                    System.out.println("Invalid balance");
                }
            }

            int choice;

            while (true) {

                System.out.println("Select Account Type");
                System.out.println("1 Savings");
                System.out.println("2 Current");

                String input = scanner.nextLine();

                if (input.matches("[12]")) {
                    choice = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Invalid choice");
                }
            }

            if (choice == 1) {

                double interest;

                while (true) {

                    System.out.print("Enter Interest Rate: ");
                    String input = scanner.nextLine();

                    if (input.matches("\\d+(\\.\\d+)?")) {
                        interest = Double.parseDouble(input);
                        break;
                    } else {
                        System.out.println("Invalid interest rate");
                    }
                }

                accounts[count] = new SavingsAccount(accNumber, name, balance, interest);

            } else {

                double overdraft;

                while (true) {

                    System.out.print("Enter Overdraft Limit: ");
                    String input = scanner.nextLine();

                    if (input.matches("\\d+(\\.\\d+)?")) {
                        overdraft = Double.parseDouble(input);
                        break;
                    } else {
                        System.out.println("Invalid overdraft limit");
                    }
                }

                accounts[count] = new CurrentAccount(accNumber, name, balance, overdraft);
            }

            count++;

            System.out.println("Account Created Successfully\n");

            if (count == accounts.length) {
                break;
            }

            System.out.print("Create another account? (yes/no): ");

            String option = scanner.nextLine();

            if (!option.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nFINAL ACCOUNT DETAILS\n");

        for (int i = 0; i < count; i++) {

            accounts[i].displayAccountDetails();
        }

        scanner.close();
    }
}