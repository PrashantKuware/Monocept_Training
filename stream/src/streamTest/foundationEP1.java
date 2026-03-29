package streamTest;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class foundationEP1 
{
	public static void main(String[] args)
	{
		Supplier<String> supplier = new Supplier<>()
			{
				@Override
				public String get()
				{
					return "Hello Streams !";
				}
			};
		
		Consumer<String> consumer = new Consumer<>()
			{
				@Override
				public void accept(String str)
				{
					System.out.println("Printing the string : "+str);
				}
			};
			
		Stream<String> streaOfString = Stream.generate(supplier);
		streaOfString.forEach(consumer);
	}
}
