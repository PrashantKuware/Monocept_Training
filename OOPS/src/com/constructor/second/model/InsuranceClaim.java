package com.constructor.second.model;

public class InsuranceClaim 
{
	 private static int counter = 1001; 
	 private final String claimId;
	 private final String policyNumber;
	 private double claimAmount;
	 private double approvedAmount=0;
	 
	 public InsuranceClaim( String policyNumber, double claimAmount)
	 {
		 if(claimAmount <= 0)
			{
 				System.out.println("Enter valid number (greater than 0).");
			}
		 
		 this.policyNumber = policyNumber; 
		 this.claimAmount = claimAmount;
		 this.claimId = "claimId"+counter++;
	 }
	 
	 public String getClaimId()
	 {
		return claimId;
	 }
	 
	 public double getAmount()
	 {
		 return approvedAmount = approvedAmount*0.085;
	 }
	 public String getpolicyNumber()
	 {
		 return policyNumber;
	 }
	 
	 
}
