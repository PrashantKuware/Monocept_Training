package assignment1.ProductInventory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            try {
                System.out.print("Enter number of products: ");
                n = sc.nextInt();

                if (n <= 0) {
                    System.out.println("Products must be greater than 0.");
                    continue;
                }
                break;
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
            }
        }

        Inventory inventory = new Inventory(n);

        for(int i = 0; i < n; i++) {

            System.out.println("\nEnter Product " + (i+1) + " Details");

//          **********  Product Id  *****************
            
            
            int id;

            while (true) {
                try {
                    System.out.print("Enter Product ID: ");
                    id = sc.nextInt();

                    if (id <= 0) {
                        System.out.println("Product ID must be positive.");
                        continue;
                    }
                    break;
                } 
                catch (InputMismatchException e) {
                    System.out.println("Invalid input. Enter a numeric ID.");
                    sc.next();
                }
            }

            sc.nextLine();

//          **********  Product Name  *****************

            
            System.out.print("Enter Product Name: ");
            String name;

            while (true) {
                
                name = sc.nextLine();

                if (!name.trim().isEmpty())
                    break;

                System.out.println("Product name cannot be empty.");
            }
            
//          **********  Price  *****************
            
            
            double price;

            while (true) {
                try {
                    System.out.print("Enter Base Price: ");
                    price = sc.nextDouble();

                    if (price < 0) {
                        System.out.println("Price cannot be negative.");
                        continue;
                    }
                    break;
                } 
                catch (InputMismatchException e) {
                    System.out.println("Invalid price. Enter numeric value.");
                    sc.next();
                }
            }
            
//          **********  choosing category  *****************

            System.out.println("Choose Category");
            System.out.println("1 Electronics");
            System.out.println("2 Clothing");
            System.out.println("Press anything for General Category");

            int choice = sc.nextInt();
            sc.nextLine();

            String categoryName = "";

            if(choice == 1)
                categoryName = "Electronics";
            else if(choice == 2)
                categoryName = "Clothing";
            else  
                categoryName = "General";
//            else if(choice > 2)
//            {
//            	try {
//
//            		 categoryName = "General";
//            		 break;
//                    
//                } 
//                catch (InputMismatchException e) {
//                    System.out.println("Invalid choice. Enter numeric value.");
//                    sc.next();
//                }
//            }

            Category category = new Category(categoryName);

            Product product = new Product(id, name, price, category);

            inventory.addProducts(product);
        }

        System.out.println("\nInventory Details");
        System.out.println("====================");

        inventory.displayDetails();
    }
}