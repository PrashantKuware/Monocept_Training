package assigment1.filter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

 class six 
{

	static class Student
	{
		int id;
		String name;
		double marks;
		
		Student(int id, String name, double marks)
		{
			this.id = id;
			this.name=name;
			this.marks=marks;
		}
	}
	
	public static void main(String[] args) 
	{
		
		List<Student> student = Arrays.asList(
				new Student(101, "Aman", 89.5),
				new Student(102, "Ram", 45.7),
				new Student(103, "Prashant",75.0),
				new Student(104, "Asus", 38.45),
				new Student(105, "Laptop", 97.12)
				);
		
		Function<Double, String> getGrade = marks -> {
			if(marks >= 75) return "A";
			else if(marks >= 50 && marks <= 74) return "B";
			else  return "FAIL";
		};
		
		student.stream().forEach(s -> System.out.println("Marks: " + s.marks + ", Grade: " + getGrade.apply(s.marks)));
	}

}
