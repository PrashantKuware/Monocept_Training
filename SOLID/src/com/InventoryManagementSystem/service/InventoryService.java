package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.model.Product;
import com.InventoryManagementSystem.notification.Notifier;
import com.InventoryManagementSystem.strategy.ValuationStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService 
{
	private Map<String, Product> inventory = new HashMap<>();
	private List<Notifier> notifiers;
	private ReorderService reorderService;
	
	public InventoryService(List<Notifier> notifiers, ReorderService reorderService) 
	{
        this.notifiers = notifiers;
        this.reorderService = reorderService;
    }
	
	public void addProduct(Product product)
	{
		inventory.put(product.getname(), product);
	}
	
	public void removeStock(String name, int qty)
	{
		Product product = inventory.get(name);
		
		product.setQuantity(product.getQuantity()-qty);
		 System.out.println("Stock updated: Removed " + qty + " units of '" + name + "'");
		 System.out.println("Current stock for " + name + ": " + product.getQuantity());
		 
		 checkReorder(product);
	}
	
	private void checkReorder(Product product)
	{
		if(product.getQuantity() < product.getMinQuantity())
		{
			 notifyAll("Low stock alert for '" + product.getname() + "'");
			 reorderService.reorder(product);
		}
	}
	
	private void notifyAll(String message)
	{
		for (Notifier notifier : notifiers) 
		{
            notifier.notify(message);
		}
	}
		
		 public void calculateInventoryValue(ValuationStrategy strategy) 
    {
			 double value = strategy.calculate(new ArrayList<>(inventory.values()));
			    System.out.println("Total inventory value: " + value);
	}
		 
		 public void viewAllProducts() {

			    if (inventory.isEmpty()) {
			        System.out.println("Inventory is empty.");
			        return;
			    }

			    System.out.println("\n===== Available Products =====");

			    for (Product p : inventory.values()) 
			    {
			        System.out.println("----------------------------");
			        System.out.println("Product Name : " + p.getname());
			        System.out.println("Quantity     : " + p.getQuantity());
			        System.out.println("Price        : " + p.getPrice());
			        System.out.println("Reorder Level or Minimum Quantity : " + p.getMinQuantity());
			        System.out.println("Maximum Quantity: " + p.getMaxQuantity());
			    }

			    System.out.println("----------------------------");
			}
}
