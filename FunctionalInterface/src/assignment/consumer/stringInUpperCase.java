package assignment.consumer;

import java.util.Scanner;
import java.util.function.Consumer;

public class stringInUpperCase 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string");
		String input = scanner.nextLine();
		
		Consumer<String> getUpper = str -> System.out.println(str.toUpperCase());
		
		getUpper.accept(input);
	}

}
