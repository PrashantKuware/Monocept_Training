package assigment1.map;

import java.util.Arrays;
import java.util.List;

public class first 
{

	public static void main(String[] args)
	{
		List<String> list = Arrays.asList("Raman", "Aman", "Sohan", "arti", "Asus", "Laptop");
		
		list.stream().map(name -> name.toUpperCase()).forEach(n -> System.out.println(n));
	}

}
