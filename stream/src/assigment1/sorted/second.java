package assigment1.sorted;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class second 
{

	public static void main(String[] args) 
	{
		List<String> list = Arrays.asList( "Laptop", "Mobile", "Tablet");
		// 1 method
//		list.stream().sorted().forEach(n -> System.out.println(n));
		// 2 method
//		Collections.sort(list);
//		 System.out.println(list);
		
		// in reverse order
		
		// 1 method
//		list.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.println(n));
//		
		// 2 method
//		Collections.sort(list, Comparator.reverseOrder());
//		 System.out.println(list);
	}

}
