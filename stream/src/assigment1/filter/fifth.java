package assigment1.filter;

import java.util.Arrays;
import java.util.List;

class Product
{
	String name;
	int price;
	
	public Product(String name, int price)
	{
		this.name=name;
		this.price=price;
	}
}

public class fifth 
{

	public static void main(String[] args) 
	{
		List<Product> list = Arrays.asList(
				new Product("Pen", 600),
				new Product("Copy", 300),
				new Product("Pencil", 200),
				new Product("Bag", 789),
				new Product("Scale", 501)
				);
		
		list.stream().filter(p -> p.price > 500).forEach(n -> System.out.println("Product : "+n.name+", Price : "+n.price));
	}

}
