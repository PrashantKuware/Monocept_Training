package com.ComparatorAndComparable.third;

import java.util.Comparator;

public class nameComparator implements Comparator<Movies>
{
	public int compare(Movies name1, Movies name2 )
	{
		return name1.getMovieName().compareTo(name2.getMovieName());
	}
}
