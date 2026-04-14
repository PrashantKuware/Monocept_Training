package streamTest;

import java.util.stream.Stream;

public class ParallelStreamExample 
{

	public static void main(String[] args)
	{
//		long start = System.currentTimeMillis();
		Stream.of(1,2,3,4,5,6,7,8,9).filter(n -> n%2==0).forEach(System.out::println);
//		Stream.of(1,2,3,4,5,6,7,8,9).parallel().filter(n -> n%2==0).forEach(System.out::println);
//		long end = System.currentTimeMillis();
//		
//		System.out.println("Time taken : "+ (end-start));
		
		
//		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}
