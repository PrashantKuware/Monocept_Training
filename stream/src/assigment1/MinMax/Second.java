package assigment1.MinMax;

import java.util.Arrays;
import java.util.List;

public class Second 
{
	public static void main(String[] args)
	{
		List<String> list = Arrays.asList("Karan", "Manish", "Lala", "Ganedsash");
		String longest = list.stream().max((a,b) -> a.length()-b.length()).orElseThrow();
		System.out.println(longest);
	}
}
