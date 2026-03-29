package com.ComparatorAndComparable.second;

import java.util.Comparator;

public class fareComparator implements Comparator<Flight>
{
	@Override
	public int compare(Flight fare1, Flight fare2)
	{
		return (int) fare2.getfare().compareTo(fare1.getfare());
	}
}
