package com.encapsulation.second.model;
 public class InsuranceClaim {

	 private final String claimId;
	    private String policyNumber;
	    private double claimAmount;
	    private double approvedAmount;
	    private ClaimStatus claimStatus;

	    public InsuranceClaim(String claimId, String policyNumber, double claimAmount) 
	    {
	    	if(claimAmount <= 0)
				{
	    		System.out.println("Enter valid number (greater than 0).");
				}
				

	        this.claimId = claimId;
	        this.policyNumber = policyNumber;
	        this.claimAmount = claimAmount;
	        this.claimStatus = ClaimStatus.FILED;
	        this.approvedAmount = 0;
	    }
    
   
    public String getClaimId() {
        return claimId;
    }
    
   
    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

  //***********************************approveClaim******************************************

    public void approveClaim(double amount) {

        ensureNotSettled();

        if (claimStatus != ClaimStatus.FILED) {
            throw new IllegalStateException("Only FILED claims can be approved.");
        }

        if (amount < 0 || amount > claimAmount) {
            throw new IllegalArgumentException("Approved amount must be between 0 and claim amount.");
        }

        this.approvedAmount = (amount*85)/100;
        this.claimStatus = ClaimStatus.APPROVED;
    }

    //***********************************filedClaim******************************************
    
    public void filedClaim() {

        this.claimStatus = ClaimStatus.FILED;
    }
    public ClaimStatus getFiledClaim() {
        return claimStatus;
    }
    
//    ------------------------Rejected-------------------------------*****************************
    
    public void rejectClaim() {

        ensureNotSettled();

        if (claimStatus != ClaimStatus.FILED) {
            throw new IllegalStateException("Only FILED claims can be rejected.");
        }

        this.claimStatus = ClaimStatus.REJECTED;
    }
    
//***********************************Settled******************************************
    
    public void settleClaim() {

        if (claimStatus != ClaimStatus.APPROVED) {
        	this.approvedAmount = 0;
        	this.claimStatus = ClaimStatus.REJECTED;
        	System.out.println("Your claim is rejected");
//            throw new IllegalStateException("Only APPROVED claims can be settled.");
        }

        else
        {
        	this.claimStatus = ClaimStatus.SETTLED;
        }
    }

  //***********************************ensureNotSettled******************************************

    private void ensureNotSettled() {
        if (claimStatus == ClaimStatus.SETTLED) {
            throw new IllegalStateException("Settled claim cannot be modified.");
        }
    }

   
    @Override
    public String toString() {
        return "InsuranceClaim {" +
                "claimId='" + claimId + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", claimAmount=" + claimAmount +
                ", approvedAmount=" + approvedAmount +
                ", ClaimStatus=" + claimStatus +
                '}';
    }
}
