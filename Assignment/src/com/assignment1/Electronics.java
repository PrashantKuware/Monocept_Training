package com.assignment1;

class Electronics extends Product {

    private String brand;
    private int warrantyYears;

    public Electronics(int productId, String productName, double basePrice,
                       String brand, int warrantyYears) {

        super(productId, productName, basePrice);

        if (warrantyYears < 0)
            throw new IllegalArgumentException("Warranty cannot be negative");

        this.brand = brand;
        this.warrantyYears = warrantyYears;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Category: Electronics");
        System.out.println("Brand: " + brand);
        System.out.println("Warranty: " + warrantyYears + " years");

        System.out.println("--------------------------------");
    }
}