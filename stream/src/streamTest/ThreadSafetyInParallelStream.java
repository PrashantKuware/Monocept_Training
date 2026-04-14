package streamTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadSafetyInParallelStream 
{

	public static void main(String[] args) 
	{
		//Not thread safe
		List<Integer> list = IntStream.rangeClosed(1, 1000).boxed().toList();
		List<Integer> result = new ArrayList<>();
		list.stream().parallel().forEach(System.out::println);
		
		// Thread safe
//		List<Integer> result = list.parallelStream().collect(Collectors.toList());
//		System.out.println(result);
		
		
		
	}

}
