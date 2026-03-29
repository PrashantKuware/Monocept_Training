package assignment.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class Invoice
{
	String name;
	int quantity;
	int price;
	
	Invoice(String name, int quantity, int price)
	{
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
}

public class invoiceFormatter 
{

	public static void main(String[] args)
	{
		List<Invoice> invoice = Arrays.asList(
				new Invoice("Pen", 5, 2),
				new Invoice("Copy", 3, 100),
				new Invoice("Pencil", 10, 5),
				new Invoice("Rubber", 2, 5),
				new Invoice("Scale", 1, 25)
				
				);
		
		Consumer<Invoice> getInvoice = data -> System.out.println("Item : "+data.name+", Quantity : "+data.quantity+ ", Price : "+data.price+", Total : "+(data.price*data.quantity));
		
		for(Invoice i : invoice)
		{
			getInvoice.accept(i);
		}

	}

}
