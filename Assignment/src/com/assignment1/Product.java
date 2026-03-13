package com.assignment1;

class Product 
{

    private int productId;
    private String productName;
    private double basePrice;

    public Product(int productId, String productName, double basePrice) {

        if (productId <= 0)
            throw new IllegalArgumentException("Product ID must be positive");

        if (productName == null || productName.trim().isEmpty())
            throw new IllegalArgumentException("Product name cannot be empty");

        if (basePrice < 0)
            throw new IllegalArgumentException("Price cannot be negative");

        this.productId = productId;
        this.productName = productName;
        this.basePrice = basePrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Base Price: " + basePrice);
    }
}