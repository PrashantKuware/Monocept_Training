package com.encapsulation.first.test;

import java.util.Scanner;

import com.encapsulation.first.model.Account_Data;

public class Account 
{

	public static void main(String[] args) 
	{
		
		Scanner scanner = new Scanner(System.in);
		Account_Data account = new Account_Data();
		
		System.out.println("Enter your name");
		String ac_holder_name = scanner.nextLine();
		account.setAccountHolder(ac_holder_name);
		String transactionContinue = "false";
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("Name :"+account.getAccountHolder());
			System.out.println("Account Number :"+account.getAccountNumber());
			System.out.println("Press 1 for Deposit");
		    System.out.println("Press 2 for Withdraw");
		    System.out.println("Press 0 for Balance Check");
		    int task;
		   
		    
		    while(true)
		    {
		    	if (scanner.hasNextInt()) 
		    	{
		            task = scanner.nextInt();
		            scanner.nextLine();
		            break;
		        } else 
		        {
		            System.out.println("Invalid input. Please enter 0, 1 or 2.");
		            scanner.nextLine(); 
		        }
		    }

		 			switch(task)
		 			{
		 			case 0 : 
		 				double balance = account.checkBalance();
		 		        System.out.println("Your account balance is :"+balance);
		 		        break;
		 		     
		 			case 1 :
		 				
		 				double deposit_amount = 0;
		 				while(true)
		 				{
		 					System.out.println("Enter the amount to deposit:");
		 					if(scanner.hasNextDouble())
		 					{
		 						deposit_amount = scanner.nextDouble();
		 						scanner.nextLine();
		 						
		 						if(deposit_amount > 0)
		 						{
		 							account.deposit(deposit_amount);
		 							 break;
		 						}
		 						else
		 						{
		 							System.out.println("Enter the valid number");
		 						}
		 					}
		 					else
		 					{
		 						System.out.println("Invalid input. Please enter numeric value.");
		 			            scanner.nextLine();
		 					}
		 				}
		 				break;
		 				
		 				 
		 			case 2 :
		 				
		 				double withdraw_amount = 0;
		 				while(true)
		 				{
		 					System.out.println("Enter the amount to withdraw");
		 					if(scanner.hasNextDouble())
		 					{
		 						withdraw_amount = scanner.nextDouble();
		 						scanner.nextLine();
		 						
		 						if(withdraw_amount > 0)
		 						{
		 							account.withdraw(withdraw_amount);
		 							break;
		 						}
		 						else
		 						{
		 							System.out.println("Enter valid number (greater than 0).");
		 						}
		 					}
		 					else
		 					{
		 						 System.out.println("Invalid input. Please enter numeric value.");
		 				            scanner.nextLine();
		 					}
		 				}
		 				break;
		 			default:
		 		            System.out.println("Invalid option selected.");
		 			}
		 			System.out.println("If you want to continue the transaction type Yes");
		 			 transactionContinue = scanner.nextLine();
		 			 if(!transactionContinue.equalsIgnoreCase("yes"))
		 			 {
		 				 break;
		 			 }
		    	}
		while(transactionContinue.equalsIgnoreCase("yes"));System.out.println("Thank you for banking with us!");scanner.close();


		    }
	}
        

