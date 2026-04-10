package assigment1.findFirst;

import java.util.Arrays;
import java.util.List;

public class First 
{
	public static void main(String[] args)
	{
		 List<String> names = Arrays.asList("Aman", "Rahul", "Priya");
		 
		 String firstElement = names.stream().findFirst().orElse("List is empty");
		 System.out.println(firstElement);
	}
}
