package streamTest;
import java.util.stream.*;

public class IntStreamExample
{

	public static void main(String[] args)
	{
//		IntStream.range(1,10)
//			    .filter(x -> x % 2 == 0)
//			    .forEach(System.out::println);
		
		// *****************************************************
		
//		IntStream stream = IntStream.range(1, 5);
//		stream.forEach(System.out::println);
//		
		// *****************************************************
		
//		IntStream.iterate(0, n -> n + 2)
//        .limit(5)
//        .forEach(System.out::println);
		
		// *****************************************************
		
//		int[] arr = {1, 2, 3};
//
//		IntStream stream = Arrays.stream(arr);
		
		// *****************************************************
		
		Stream<Integer> stream = IntStream.of(1,2,3).boxed();
		stream.forEach(System.out::println);
	}

}
