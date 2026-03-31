package assigment1.map;

import java.util.Arrays;
import java.util.List;

class Product
{
	String name;
	int price;
	Product(String name, int price)
	{
		this.name=name;
		this.price=price;
	}
}

public class fifth 
{

	public static void main(String[] args) 
	{
		List<Product> list = List.of(
				new Product("Pen", 25),
				new Product("Copy", 70),
				new Product("Rubber", 5),
				new Product("Scale", 10),
				new Product("Laptop", 64500)
				);
		
		list.stream()
	    .forEach(p -> {
	        double newPrice = p.price * 0.9;
	        System.out.println(
	            "Product Name: " + p.name +
	            ", Old Price: " + p.price +
	            ", New Price: " + newPrice
	        );
	    });
	}

}
