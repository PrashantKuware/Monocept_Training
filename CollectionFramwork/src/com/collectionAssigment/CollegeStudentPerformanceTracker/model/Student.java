package com.collectionAssigment.CollegeStudentPerformanceTracker.model;

import java.util.*;
import java.util.concurrent.Callable;

public class Student implements Comparable<Student>
{
	protected int id;
	protected String name;
	protected String department;
	Map<String, Integer> marks;
	
	public Student(int id, String name, String department)
	{
		this.id = id;
		this.name = name;
		this.department = department;
		this.marks = new HashMap<>();
	}
	
	public void addMarks(String subject, int score)
	{
		marks.put(subject, score);
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getDept()
	{
		return department;
	}
	
	public double getAverage()
	{
		if(marks.isEmpty()) return 0;
		
		int sum=0;
		for(int m : marks.values())
		{
			sum = sum+m;
		}
		return sum/marks.size();
	}
	
	public int CompareTo(Student s)
	{
		return Double.compare(s.getAverage(), this.getAverage());
	}
	
	public String toString() 
	{
        String type = this.getClass().getSimpleName().replace("Student", "");
        return id + " | " + name + " | " + department + " | "
                + type + " | Avg: " + getAverage();
    }

	
}
