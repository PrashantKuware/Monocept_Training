package com.InventoryManagementSystem.test;

import java.util.*;

import com.InventoryManagementSystem.model.Product;
import com.InventoryManagementSystem.notification.*;
import com.InventoryManagementSystem.service.*;
import com.InventoryManagementSystem.strategy.*;
import com.InventoryManagementSystem.strategy.ValuationStrategy;


 class Main {

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        List<Notifier> notifiers = List.of(
                new SMSNotifier()
        );

        InventoryService service = new InventoryService
        (
                notifiers,
                new ReorderService()
        );

        while (true) 
        {
            try {
                System.out.println("\nEnter your choice from below options");
                System.out.println();
                System.out.println("1. Add Product");
                System.out.println("2. Remove Stock");
                System.out.println("3. View Inventory Value");
                System.out.println("4. View All Products");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) 
                {

                    case 1:
                        // Add Product
                        System.out.print("Enter product name: ");
                        String name = sc.nextLine();

                        if (name.trim().isEmpty()) 
                        {
                            throw new IllegalArgumentException("Product name cannot be empty");
                        }

                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();

                        if (qty <= 0) 
                        {
                            throw new IllegalArgumentException("Quantity must be greater than 0");
                        }

                        System.out.print("Enter price: ");
                        double price = sc.nextDouble();

                        if (price <= 0) 
                        {
                            throw new IllegalArgumentException("Price must be greater than 0");
                        }
                        
                        System.out.print("Enter minimum quqntity: ");
                        int reorderMin = sc.nextInt();

                        if (reorderMin < 0) 
                        {
                            throw new IllegalArgumentException("Reorder level cannot be negative");
                        }
                        
                        System.out.print("Enter maximum quqntity: ");
                        int reorderMax = sc.nextInt();

                        if (reorderMax < 0) 
                        {
                            throw new IllegalArgumentException("Reorder level cannot be negative");
                        }
                        
                        System.out.print("Product is Perishable : true/false ");
                        boolean isPerishable = sc.nextBoolean();

                        if (isPerishable != true && isPerishable != false) 
                        {
                            throw new IllegalArgumentException("Reorder level cannot be negative");
                        }
                        service.addProduct(new Product(name, qty, price, reorderMin, reorderMax, isPerishable));
                        System.out.println("Product added successfully!");
                        break;

                    case 2:
                        // Remove Stock
                        System.out.print("Enter product name: ");
                        String removeName = sc.nextLine();

                        if (removeName.trim().isEmpty()) 
                        {
                            throw new IllegalArgumentException("Product name cannot be empty");
                        }

                        System.out.print("Enter quantity to remove: ");
                        int removeQty = sc.nextInt();

                        if (removeQty <= 0) 
                        {
                            throw new IllegalArgumentException("Quantity must be greater than 0");
                        }

                        service.removeStock(removeName, removeQty);
                        break;

                    case 3:
                        // View Inventory Value
                        service.calculateInventoryValue(new ValuationStrategy());
                        break;
        
                    case 4:
                        service.viewAllProducts();
                        break;
                        
                    case 5:
                        System.out.println("Exiting system...");
                        sc.close();
                        System.exit(0);
                        
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter correct values.");
                sc.nextLine(); 
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine(); 
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
                sc.nextLine(); 
            }
        }
    }
}