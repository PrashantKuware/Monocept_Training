package com.exceptionHandling.testing;

import java.util.Scanner;

public class throwKeyword {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int marks;
		
			try
			{
				System.out.println("Enter the marks");
				marks = scanner.nextInt();
				if(validateMarks(marks)) 
				{
					throw new IllegalArgumentException ("Marks should be between 0 - 100");
				}
				else
				{
					
					System.out.println("Valid marks");
				}
			}
			finally {
	            System.out.println("session ended");
	            
	        }

	}
	public static boolean validateMarks(int marks)
	{
		if( marks < 0 || marks > 100)
		{
			return true;
		}
		return false;
	}

}
