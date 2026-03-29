package com.arrayofObject.first.model;

public abstract  class Course 
{
    protected long courseId;
    protected String courseName;
    protected double baseFee;
    
    protected static int totalCourses = 0;
    
    public Course(long courseId, String courseName, double baseFee)
    {
    	this.courseId = courseId;
    	this.courseName = courseName;
    	this.baseFee = baseFee;
    	totalCourses++;
    }
    
    public double calculatefee()
    {
    	return baseFee;
    }
    public double calculatefee(double extraCharges)
    {
    	return baseFee + extraCharges;
    }
    
    public abstract double calculateTotalFee();
    
    public void displayCourses()
    {
    	System.out.println("Course ID   : " + courseId);
        System.out.println("Course Name : " + courseName);
        System.out.println("Final Fee   : " + calculateTotalFee());
        System.out.println("-----------------------------");
    }
    
    public static int getTotalCourses()
    {
    	return totalCourses;
    }
}