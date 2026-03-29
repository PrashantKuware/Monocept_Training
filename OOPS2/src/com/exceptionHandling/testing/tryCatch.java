package com.exceptionHandling.testing;

import java.util.Scanner;

public class tryCatch {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int number1, number2, result;
		System.out.println("Enter first number");
		number1 = scanner.nextInt();
		System.out.println("Enter second number");
		number2 = scanner.nextInt();
		try {
			result = number1/number2;
			 System.out.println("Result : "+result);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception using getMessage :" + e.getMessage());
			System.out.println("Exception using toString :" + e.toString());
			System.out.println("Exception using printStackTrace");
			e.printStackTrace();
		}

	}

}
