package com.abstractImplimentation.first.test;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.abstractImplimentation.first.model.*;



public class DigitalPaymentSystem 
{

    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);
        int noOfPayment,choice;
        double amount ;
        String temperorynoOfPayment, temperorynoOfChoice, temperorynoOfAmount;

       
        
        while(true)
        {
        	 System.out.print("Enter number of payments: ");
             temperorynoOfPayment = scanner.nextLine().trim();
             if(temperorynoOfPayment.matches("[1-9]\\d*"))
             {
             	break;
             }
             System.out.println("Invalid Input, Enter greater than 0");
        }
        noOfPayment = Integer.parseInt(temperorynoOfPayment);
        
        Payment[] payments = new Payment[noOfPayment];

        for (int i = 0; i < noOfPayment; i++) 
        {

            
            while(true)
            {

                System.out.println("\nSelect Payment Type:");
                System.out.println("1. Credit Card");
                System.out.println("2. UPI");
                System.out.println("3. Wallet");
                 temperorynoOfChoice = scanner.nextLine().trim();
                 if(temperorynoOfChoice.matches("^[123]$") && Integer.parseInt(temperorynoOfChoice) > 0)
                 {
                 	break;
                 }
                 System.out.println("Invalid Input. Enter only 1, 2 or 3");
            }
           
            	choice = Integer.parseInt(temperorynoOfChoice);
           

            
            while(true)
            {
            	System.out.print("Enter payment amount: ");
                 temperorynoOfAmount = scanner.nextLine().trim();
                 if (temperorynoOfAmount.matches("\\d+(\\.\\d+)?") && Double.parseDouble(temperorynoOfAmount) > 0)                 {
                 	break;
                 }
                 System.out.println("Invalid Input");
            }
            amount = Double.parseDouble(temperorynoOfAmount);
            

            switch (choice) 
            {

                case 1:
                    payments[i] = new CreditCardPayment(amount);
                    break;

                case 2:
                    payments[i] = new UPIPayment(amount);
                    break;

                case 3:
                    payments[i] = new WalletPayment(amount);
                    break;

                default:
                    System.out.println("Invalid choice! Defaulting to UPI.");
                    payments[i] = new UPIPayment(amount);
            }
        }

        System.out.println("\n===== Processing Payments =====");

        for (Payment payment : payments) {
            payment.processPayment();     
            payment.generateReceipt();    
        }

        scanner.close();
    }
}