package com.ComparatorAndComparable.fourth;

import java.util.*;

class Product {

    private String category;
    private String name;
    private double price;

    Product(String category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Product { Category: " + category +
                ", Name: " + name +
                ", Price: " + price + " }";
    }
}

public class ProductTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();

        String category, name;
        double price;

        while(true)
        {

            // CATEGORY VALIDATION
            while(true)
            {
                System.out.println("Enter Product Category:");

                category = scanner.nextLine().trim();

                if(!category.matches("[a-zA-Z ]+"))
                {
                    System.out.println("Invalid category. Use letters only.");
                    continue;
                }

                break;
            }

            // PRODUCT NAME VALIDATION
            while(true)
            {
                System.out.println("Enter Product Name:");

                name = scanner.nextLine().trim();

                if(!name.matches("[a-zA-Z0-9 ]+"))
                {
                    System.out.println("Invalid product name.");
                    continue;
                }

                break;
            }

            // PRICE VALIDATION
            while(true)
            {
                System.out.println("Enter Product Price:");

                String tempPrice = scanner.nextLine().trim();

                if(!tempPrice.matches("^[+]?(\\d+(\\.\\d*)?|\\.\\d+)$"))
                {
                    System.out.println("Invalid price.");
                    continue;
                }

                price = Double.parseDouble(tempPrice);

                if(price <= 0)
                {
                    System.out.println("Price must be greater than 0.");
                    continue;
                }

                break;
            }

            list.add(new Product(category, name, price));

            System.out.println("Add more products? (yes/no)");
            String choice = scanner.nextLine();

            if(choice.equalsIgnoreCase("no"))
                break;
        }

        Collections.sort(list, new ProductComparator());

        System.out.println("\nSorted Products:\n");

        for(Product p : list)
        {
            System.out.println(p);
        }

        scanner.close();
    }
}