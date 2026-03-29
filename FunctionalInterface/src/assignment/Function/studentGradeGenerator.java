package assignment.Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class studentGradeGenerator 
{

	public static void main(String[] args) 
	{
		List<Integer> marksList = Arrays.asList(75, 54, 48, 98, 33);
		
		Function<Integer, String> getGrade = marks -> {
			if(marks >= 75) return "A";
			else if(marks >= 50 && marks <= 74) return "B";
			else  return "FAIL";
		};
		
//		for(Integer s : marksList)
//		{
//			System.out.println("Marks: " + s + ", Grade: " + getGrade.apply(s));
//		}
		
		marksList.stream().forEach(s -> System.out.println("Marks: " + s + ", Grade: " + getGrade.apply(s)));
	}

}
