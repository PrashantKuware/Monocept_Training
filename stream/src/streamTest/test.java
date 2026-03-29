package streamTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test 
{

	public static void main(String[] args)
	{
		
//		Stream s = List.of("A", "B", "C").stream();
//		List<String> list = List.of("A", "B", "C");
//		 
//		long count = list.stream().count(); 
//		long count2 = list.stream().count(); 
//
//		System.out.println(count);
//		
////		long count2 = s.count();
//		
//		System.out.println(count2);
		
		
		
		List<Integer> input = List.of(2,7,3,78,2,8,0);
		Set<Integer> output1 =  input.stream().sorted().dropWhile(x->x%2==0).collect(Collectors.toSet());
		List<Integer> output2 =  input.stream().sorted().dropWhile(x->x%2==0).toList();

//		List<Integer> first3 = IntStream.rangeClosed(1,10).boxed().skip(3).toList();
		System.out.println(output1);
		System.out.println(output2);

	}

}
