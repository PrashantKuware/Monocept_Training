package com.String;

import java.util.Scanner;

public class PasswordValidator {

	public static void main(String[] args) 
	{
		String password;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Password ");
		password = scanner.nextLine();
		String passwordWithoutSpace = password.replace(" ", "");
		System.out.println("Entered Password : "+password);
		System.out.println(" Password without space : "+passwordWithoutSpace);
		
		if(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%&?=!_]).{8,}$"))
		{
			System.out.println(" Password length: "+passwordWithoutSpace.length());
			System.out.println("Contain Uppercase : Yes");
			System.out.println("Contain LowerCase : Yes");
			System.out.println("Contain Digit : Yes");
		}
		else
		{
			System.out.println("Something went wrong! Please enter again");
	
		}
		
		scanner.close();
	}

}
