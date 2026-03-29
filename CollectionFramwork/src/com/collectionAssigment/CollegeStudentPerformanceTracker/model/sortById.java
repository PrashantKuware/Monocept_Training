package com.collectionAssigment.CollegeStudentPerformanceTracker.model;

import java.util.Comparator;

public class sortById implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		return s1.id - s2.id;
	}
}