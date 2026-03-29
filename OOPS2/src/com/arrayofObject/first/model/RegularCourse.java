package com.arrayofObject.first.model;
import com.arrayofObject.first.model.Course;

public class RegularCourse extends Course
{
	private double labFee=100;
	public RegularCourse(long id, String courseName, double baseFee)
	{
		super(id, courseName, baseFee);
		
	}
	@Override
    public double calculateTotalFee() {
        return calculatefee(labFee); 
    }
}
