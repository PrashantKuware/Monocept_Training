package com.assignment1;

class Clothing extends Product {

    private String size;
    private String fabric;

    public Clothing(int productId, String productName, double basePrice,
                    String size, String fabric) {

        super(productId, productName, basePrice);

        this.size = size;
        this.fabric = fabric;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Category: Clothing");
        System.out.println("Size: " + size);
        System.out.println("Fabric: " + fabric);

        System.out.println("--------------------------------");
    }
}