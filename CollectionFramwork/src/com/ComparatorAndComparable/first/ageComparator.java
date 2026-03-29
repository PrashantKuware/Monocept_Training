package com.ComparatorAndComparable.first;

import java.util.Comparator;

public class ageComparator implements Comparator<Student>
{

	@Override
	public int compare(Student age1, Student age2) {
		// TODO Auto-generated method stub
		return age1.getAge().compareTo(age2.getAge());
	}

}
