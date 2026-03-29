package assignment.Supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class productListGenerator 
{

	public static void main(String[] args) 
	{
		Supplier<List<String>> productSupplier = () -> Arrays.asList("Mobile","Laptop","TV","Book");
		
		List<String> products = productSupplier.get();
		
		for(String product : products)
		{
			System.out.println(product);
		}

	}

}
