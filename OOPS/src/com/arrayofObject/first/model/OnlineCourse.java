package com.arrayofObject.first.model;

class OnlineCourse extends Course 
{
	private double platformFee=300;
	public OnlineCourse(long courseId, String courseName, double baseFee)
	{
		super(courseId, courseName, baseFee);
		
	}
	 @Override
	    public double calculateTotalFee() {
	        return calculatefee(platformFee); // method overloading used
	    }
}
