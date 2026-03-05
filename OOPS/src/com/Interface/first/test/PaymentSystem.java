package com.Interface.first.test;

import java.util.Scanner;
import com.Interface.first.model.*;

 class PaymentSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Payment payment = null;
        String input;
        int choice;

        while (true) {

            System.out.println("Select Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            System.out.println("3. UPI");

            input = scanner.nextLine().trim();

            if (input.matches("[123]")) {

                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        payment = new creditCardPayment(); // FIXED
                        break;
                    case 2:
                        payment = new DebitCardPayment();
                        break;
                    case 3:
                        payment = new UPIPayment();
                        break;
                }

                break;
            }

            System.out.println("Invalid choice! Try again.");
        }

        while (true) {
            System.out.print("Enter amount: ");
            input = scanner.nextLine().trim();

            if (input.matches("\\d+(\\.\\d+)?") &&
                Double.parseDouble(input) > 0) {
                break;
            }

            System.out.println("Invalid amount! Enter value greater than 0.");
        }

        double amount = Double.parseDouble(input);

        payment.processPayment(amount);

        scanner.close();
    }
}