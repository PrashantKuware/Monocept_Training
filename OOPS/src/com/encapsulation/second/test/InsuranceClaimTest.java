package com.encapsulation.second.test;
import java.util.Scanner;

import com.encapsulation.second.model.InsuranceClaim;

 class InsuranceClaimTest {

    public static void main(String[] args) {

    	Scanner scanner = new Scanner(System.in);

    	System.out.println("Enter Claim ID:");
    	String claimId = scanner.nextLine();

    	System.out.println("Enter Policy Number:");
    	String policyNumber = scanner.nextLine();

    	double claimAmount ;
    	
    	InsuranceClaim status = null;

    	while (true) {

    	    System.out.println("Enter Claim Amount:");

    	    if (!scanner.hasNextDouble()) {
    	        System.out.println("Invalid input. Please enter numeric value.");
    	        scanner.nextLine(); 
    	        continue;
    	    }

    	    claimAmount = scanner.nextDouble();
    	    scanner.nextLine(); 

    	    if (claimAmount <= 0) {
    	        System.out.println("Enter valid number (greater than 0).");
    	        continue;
    	    }

    	    status = new InsuranceClaim(claimId, policyNumber, claimAmount);
    	    break;
    	}


    	
    	System.out.println("Welcome : "+status.getPolicyNumber()+" Your Claim Id : "+status.getClaimId());
    	System.out.println("Your Claim is "+status.getFiledClaim());
    	
    	System.out.println("Enter your choice");
    	System.out.println("Press 1 for Approve");
	    System.out.println("Press 2 for Reject");
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
	            System.out.println("Invalid input. Please enter 1 or 2.");
	            scanner.nextLine(); 
	        }
	    }
       
	    switch(task)
	    {
	    case 1:
	    	status.approveClaim(claimAmount);
	    	break;
	    	
	    case 2:
	    	status.rejectClaim();
	    	break;
	    	
	    }
	    
	    status.settleClaim();
	    System.out.println(status);

        
    }
}
