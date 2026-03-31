package streamTest;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class foundationEP1 
{
	public static void main(String[] args)
	{
		Supplier<String> supplier = () -> "Hello Streams !";
		
		Consumer<String> consumer = str -> System.out.println("Printing the string : "+str);
			
		 Stream.generate(supplier).forEach(consumer);
	}
}
