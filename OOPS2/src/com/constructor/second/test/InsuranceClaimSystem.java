package com.constructor.second.test;
import com.constructor.second.model.*;
import java.util.Scanner;

public class InsuranceClaimSystem {

	public static void main(String[] args) 
	{
		InsuranceClaim status;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Policy Number");
		String policyNumber = scanner.nextLine();
		System.out.println("Enter Claim Amount");
		double claimAmount = scanner.nextDouble();
		 
		System.out.println("Enter Claim Type");
		System.out.println("Press 1 for Normal Claim");
		System.out.println("Press 2 for Corporate Claim");
		int choice = scanner.nextInt();
		
		switch(choice)
		{
		case 1 :
			status = new InsuranceClaim(policyNumber, claimAmount);
			
		case 2 :
			status = new CorporateClaim(policyNumber, claimAmount);
		}
		
	}

}
