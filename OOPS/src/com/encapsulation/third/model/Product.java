package com.encapsulation.third.model;

public class Product 
{
	private static long counter = 100001;
	private String productName;
	private double price;
	private int stockQuantity;
	private boolean isDiscontinued;
	private final long productId ;
	
	public Product( String productName, double price, int stockQuantity)
	{
		if(productName == null || productName.isBlank())
		{
			throw new IllegalArgumentException("Product name can not be empty");
		}
		if(price < 0 )
		{
			throw new IllegalArgumentException("Price can not be negetive");
		}
		if(stockQuantity < 0)
		{
			throw new IllegalArgumentException("Stock can not be negetive");
		}
		this.productId = counter++;
		this.productName = productName;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.isDiscontinued = false;
	}
	
	public long getProductId()
	{
		return productId;
	}
	
	public String getProductName() 
	{
		return productName;
	}
	
	public double getPrice()
	{
		return price;
	}
	public int getStockQuantity() 
	{
		return stockQuantity;
	}
	public boolean isDiscontinued() 
	{
		return isDiscontinued;
	}
	
	public void increaseStock(int quantity, Role role)
	{
		validateAdmin(role);
		ensureNotDiscontinued();
		
		if(quantity <= 0)
		{
			throw new IllegalArgumentException("Quantity must be greater than 0");
		}
		stockQuantity += quantity;
		System.out.println("Quantity increased successfully");
		
	}
	
	public void reduceStock(int quantity, Role role)
	{
		validateAdmin(role);
		ensureNotDiscontinued();
		if(quantity <= 0)
		{
			throw new IllegalArgumentException("Quantity must be greater than 0");
		}
		if(quantity > stockQuantity)
		{
			 throw new IllegalArgumentException("Insufficient stock available.");
		}
		stockQuantity -= quantity;
		 System.out.println("Stock reduced successfully.");
	}
	
	public void updatePrice(double newPrice, Role role)
	{
		validateAdmin(role);
		if(newPrice < 0 )
		{
			throw new IllegalArgumentException("New price cannot be negative.");
		}
		this.price = newPrice;
		  System.out.println("Price updated successfully.");
	}
	
	public void discontinueProduct(Role role)
	{
		validateAdmin(role);
		this.isDiscontinued = true;
		 System.out.println("Product discontinued successfully.");
	}
	
	private void validateAdmin(Role role)
	{
		if(role != Role.ADMIN)
		{
			throw new SecurityException("Only Admin can perform this action");
		}
	}
	
	private void ensureNotDiscontinued() {
        if (isDiscontinued) {
            throw new IllegalStateException("Product is discontinued. Operation not allowed.");
        }
    }
	
	public String toString() {
        return " Product{" +
                "Product_Id='" + productId + '\'' +
                ", Product_Name='" + productName + '\'' +
                ", Price=" + price +
                ", Stock_Quantity=" + stockQuantity +
                ", Availability=" + isDiscontinued +
                '}';
    }
}
