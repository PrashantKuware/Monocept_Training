package com.constructor.second.model;

public class CorporateClaim extends InsuranceClaim
{
	private static final double processingFee = 100;
	
	public CorporateClaim( String policyNumber, double claimAmount)
	{
		super(policyNumber, claimAmount);
	}
}
