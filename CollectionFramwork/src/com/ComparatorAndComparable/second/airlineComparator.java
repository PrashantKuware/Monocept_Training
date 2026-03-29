package com.ComparatorAndComparable.second;

import java.util.Comparator;

public class airlineComparator implements Comparator<Flight>
{
	@Override
	public int compare(Flight airline1, Flight airline2)
	{
		return airline2.getairline().compareTo(airline1.getairline());
	}
}
