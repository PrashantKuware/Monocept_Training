package assigment1.filter;

import java.util.Arrays;
import java.util.List;

public class second 
{

	public static void main(String[] args) 
	{
		List<String> list = Arrays.asList("Raman", "Aman", "Sohan", "arti", "Asus", "Laptop");
		
		list.stream()
		.filter(n -> n.toUpperCase().startsWith("A"))
		.forEach(n -> System.out.println(n));
	}

}
