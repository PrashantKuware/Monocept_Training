package com.exceptionHandling.testing;

import java.util.Scanner;

public class finallyBlock {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int balance = 10000, amount;
		
			try
			{
				System.out.println("Enter the amount to withdraw");
				amount = scanner.nextInt();
				if(amount > balance) 
				{
					throw new ArithmeticException("Amount should be less than balance");
				}
				else
				{
					balance -= amount;
					System.out.println("remaining amount : "+balance);
				}
			}
			finally {
	            System.out.println("Transaction session ended");
	            
	        }
			

	}

}
