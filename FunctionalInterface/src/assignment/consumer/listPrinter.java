package assignment.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class listPrinter 
{

	public static void main(String[] args) 
	{
		List<String> names = Arrays.asList("java", "python", "react");
		
		Consumer<String> getString = str -> System.out.println(str);
		
		for(String name : names)
		{
			getString.accept(name);
		}

	}

}
