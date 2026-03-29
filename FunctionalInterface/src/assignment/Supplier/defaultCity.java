package assignment.Supplier;

import java.util.Scanner;
import java.util.function.Supplier;

public class defaultCity 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the city name");
		String userInput = scanner.nextLine();
		
		 Supplier<String> defaultCity = ()-> "Pune";
		 
		 String city = (userInput == null || userInput.trim().isEmpty()) ? defaultCity.get(): userInput;
		 
		 System.out.println("Entered city Name is : "+city);
	}

}
