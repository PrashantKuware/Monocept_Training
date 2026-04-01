package assigment1.sorted;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class fourth 
{

	public static void main(String[] args) 
	{
		List<String> list = Arrays.asList( "Amit", "Rahul", "Priya", "An", "Karan");
		
//		list.stream().sorted(Comparator.comparing(s->s.length())).forEach(n -> System.out.println(n));
		
//		list.stream().sorted((a,b) -> a.length()-b.length()).forEach(n -> System.out.println(n));
		
		// in reverse order
		
//		list.stream().sorted((a,b) -> b.length()-a.length()).forEach(n -> System.out.println(n));
		
		list.stream().sorted(Comparator.comparing((String s) -> s.length())
		        .reversed()
		        .thenComparing(s -> s)).forEach(n -> System.out.println(n));
	

	}

}
