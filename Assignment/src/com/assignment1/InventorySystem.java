package com.assignment1;
import java.util.Scanner;

public class InventorySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        
        while (true) {
            System.out.print("Enter number of products: ");
            n = sc.nextInt();

            if (n > 0)
                break;

            System.out.println("Number of products must be greater than 0.");
        }

        Product[] inventory = new Product[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for product " + (i + 1));

            int category;

            while (true) {

                System.out.println("Select Category");
                System.out.println("1. Electronics");
                System.out.println("2. Clothing");

                category = sc.nextInt();
                sc.nextLine();

                if (category == 1 || category == 2)
                    break;

                System.out.println("Invalid choice. Please select 1 or 2.");
            }

            int id;

            while (true) {
                System.out.print("Enter Product ID: ");
                id = sc.nextInt();

                if (id > 0)
                    break;

                System.out.println("Product ID must be positive.");
            }

            sc.nextLine();

            String name;

            while (true) {
                System.out.print("Enter Product Name: ");
                name = sc.nextLine();

                if (!name.trim().isEmpty())
                    break;

                System.out.println("Product name cannot be empty.");
            }

            double price;

            while (true) {
                System.out.print("Enter Base Price: ");
                price = sc.nextDouble();

                if (price >= 0)
                    break;

                System.out.println("Price cannot be negative.");
            }

            sc.nextLine();

            if (category == 1) {

                String brand;

                while (true) {
                    System.out.print("Enter Brand: ");
                    brand = sc.nextLine();

                    if (!brand.trim().isEmpty())
                        break;

                    System.out.println("Brand cannot be empty.");
                }

                int warranty;

                while (true) {
                    System.out.print("Enter Warranty (years): ");
                    warranty = sc.nextInt();

                    if (warranty >= 0)
                        break;

                    System.out.println("Warranty cannot be negative.");
                }

                inventory[i] = new Electronics(id, name, price, brand, warranty);

            } else {

                sc.nextLine();

                String size;

                while (true) {
                    System.out.print("Enter Size: ");
                    size = sc.nextLine();

                    if (!size.trim().isEmpty())
                        break;

                    System.out.println("Size cannot be empty.");
                }

                String fabric;

                while (true) {
                    System.out.print("Enter Fabric: ");
                    fabric = sc.nextLine();

                    if (!fabric.trim().isEmpty())
                        break;

                    System.out.println("Fabric cannot be empty.");
                }

                inventory[i] = new Clothing(id, name, price, size, fabric);
            }
        }

        System.out.println("\nINVENTORY DETAILS");
        System.out.println("====================");

        for (Product p : inventory) {
            p.displayDetails();
        }

        sc.close();
    }
}