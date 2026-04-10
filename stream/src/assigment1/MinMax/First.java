package assigment1.MinMax;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class First 
{

	public static void main(String[] args) 
	{
		List<Integer> list = Arrays.asList(23,54,65,687,23,756,324,9);
		
//		int min = list.stream().min((a,b) -> a-b) .orElseThrow();
//		System.out.println(min);
		
		int min = Collections.min(list);
		System.out.println(min);

	}

}
