package com.ComparatorAndComparable.third;

import java.util.Comparator;

public class yearComparator implements Comparator<Movies>
{
	public int compare(Movies year1, Movies year2)
	{
		return Integer.compare(year2.getYear(), year1.getYear());
	}
}
