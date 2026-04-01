package com.InventoryManagementSystem.strategy;

import java.util.List;

import com.InventoryManagementSystem.model.Product;

public class ValuationStrategy 
{
	 public double calculate(List<Product> products) {
	        return products.stream()
	                .mapToDouble(p -> p.getPrice() * p.getQuantity())
	                .sum();
	    }
}
