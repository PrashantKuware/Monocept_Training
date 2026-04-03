package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.model.Product;

public class ReorderService 
{
	public void reorder(Product product)
	{
		int maxQty = product.getMaxQuantity();
		product.setQuantity(product.getQuantity()+(product.getMaxQuantity() - product.getMinQuantity()));
		
		System.out.println("Reorder placed for " + (maxQty - product.getMinQuantity()) + " units of '" + product.getname() + "'");
	}
}
