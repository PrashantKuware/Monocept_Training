package assignment.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NonEmptyString 
{

	public static void main(String[] args)
	{
		List<String> list = Arrays.asList("", "Java", null, " ");
		Predicate<String> notNull = x -> x != null && !x.trim().isEmpty();
		
		for(String str : list)
		{
			if(notNull.test(str))
			{
				System.out.println(str);
			}
		}
	}

}
