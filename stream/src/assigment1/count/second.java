package assigment1.count;

import java.util.Arrays;
import java.util.List;

public class second 
{

	public static void main(String[] args) 
	{
		List<Integer> list = Arrays.asList(2,34,45,2,5,7,678,979,43,567,234,78,32,30);
		
	long count = list.stream().filter(n -> n%2==0).count();
	System.out.println("Total Even no : "+count+" | Total Odd no : "+(list.size()-count));

	}

}
