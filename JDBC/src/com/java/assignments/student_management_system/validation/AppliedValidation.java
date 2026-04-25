package com.java.assignments.student_management_system.validation;

import java.util.Scanner;

public class AppliedValidation 
{
	public static int idValidation(Scanner scanner)
	{
		while (true) 
		{

	        if (scanner.hasNextInt()) 
	        {
	            int value = scanner.nextInt();
	            scanner.nextLine();
	            return value;
	        } 
	        else 
	        {
	            System.out.println(" Invalid input");
	            scanner.nextLine();
	        }
        }
	}
	
	public static String stringValidation(Scanner scanner)
	{
		while (true)
		{
	        String input = scanner.nextLine().trim();

	        if (!input.isEmpty()) 
	        {
	            return input;
	        } 
	        else 
	        {
	            System.out.println(" Input cannot be empty");
	            scanner.nextLine();
	        }
	    }
	}
	public static int ageValidation(Scanner scanner)
	{
		while (true) 
		{

            if (scanner.hasNextInt()) 
            {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= 120) 
                {
                    return choice;
                } 
                else 
                {
                    System.out.println("Invalid age") ;
                }

            } 
            else 
            {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); 
            }
        }
	}
	
	public static int validateChoice(Scanner scanner)
	{
		while (true) 
		{

            if (scanner.hasNextInt()) 
            {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= 11) 
                {
                    return choice;
                } 
                else 
                {
                    System.out.println("Choice must be between (1 to 11)") ;
                }

            } 
            else 
            {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); 
            }
        }
	}
	
	public static double feesValidation(Scanner scanner) 
	{
	    while (true) 
	    {
	        System.out.print("Enter Course Fees: ");

	        if (scanner.hasNextDouble()) 
	        {
	            double fee = scanner.nextDouble();
	            scanner.nextLine();

	            if (fee > 0) return fee;
	            else System.out.println(" Fee must be positive");

	        } 
	        else 
	        {
	            System.out.println(" Invalid number");
	            scanner.nextLine();
	        }
	    }
	}
}
