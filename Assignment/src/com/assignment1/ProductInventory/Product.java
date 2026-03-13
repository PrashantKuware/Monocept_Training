package assignment1.ProductInventory;

class Product {

    private int productId;
    private String productName;
    private double initialPrice;
    private Category category;

    public Product(int productId, String productName, double initialPrice, Category category) {

        if(productId <= 0)
            throw new IllegalArgumentException("Invalid Product ID");

        if(initialPrice < 0)
            throw new IllegalArgumentException("Price cannot be negative");

        this.productId = productId;
        this.productName = productName;
        this.initialPrice = initialPrice;
        this.category = category;
    }

    public int getId() {
        return productId;
    }

    public String getProduct() {
        return productName;
    }

    public double getPrice() {
        return initialPrice;
    }

    public void display() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + initialPrice);
        System.out.println("Category: " + category.getDetails());
        System.out.println("----------------------");
    }
}