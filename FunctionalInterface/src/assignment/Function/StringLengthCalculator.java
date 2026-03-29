package assignment.Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StringLengthCalculator 
{

	public static void main(String[] args) 
	{
		 List<String> names = Arrays.asList("Amit", "Neha", "Rao");
		
		Function<String, Integer> getLength = str ->str.length();
		
		for(String s :names	)
		{
			System.out.println("Name : "+getLength.apply(s));
		}

//		names.stream().forEach(name -> System.out.println("Name : "+getLength.apply(name)));
		
	}

}
