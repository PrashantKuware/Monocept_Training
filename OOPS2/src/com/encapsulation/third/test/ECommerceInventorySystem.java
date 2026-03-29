package com.encapsulation.third.test;

import com.encapsulation.third.model.*;
import java.util.Scanner;

public class ECommerceInventorySystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Role:");
        System.out.println("1. USER");
        System.out.println("2. ADMIN");

        int roleChoice = scanner.nextInt();
        scanner.nextLine();

        Role role = (roleChoice == 2) ? Role.ADMIN : Role.USER;

        try {

            System.out.println("Enter Product Name:");
            String productName = scanner.nextLine();

            System.out.println("Enter Initial Price:");
            double price = scanner.nextDouble();

            System.out.println("Enter Initial Stock:");
            int stock = scanner.nextInt();

            Product product = new Product(productName, price, stock);

            System.out.println("\nProduct Created:");
            System.out.println(product);

            if (role == Role.ADMIN) {

                System.out.println("\nEnter stock to increase:");
                int qty = scanner.nextInt();
                product.increaseStock(qty, role);

                System.out.println("\nEnter new price:");
                double newPrice = scanner.nextDouble();
                product.updatePrice(newPrice, role);

            } else {

                System.out.println("\nEnter quantity to purchase:");
                int qty = scanner.nextInt();
                product.reduceStock(qty, role);
            }

            System.out.println("\nFinal Product Status:");
            System.out.println(product);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}