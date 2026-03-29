package assignment.predicate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

class Student
{
	String name;
	int marks;
	public Student(String name, int marks)
	{
		this.name=name;
		this.marks=marks;
	
	}
}

public class StudentPassFilter 
{

	public static void main(String[] args) 
	{
		List<Student> students = Arrays.asList(
				new Student("Amit", 40),
				new Student("Ravi", 34),
				new Student("Beha", 54),
				new Student("Ram", 45),
				new Student("Shyam", 98),
				new Student("Karan", 48)
				);
		
		Predicate<Student> isPass = s -> s.marks >= 40;
		
		for(Student st : students)
		{
			if(isPass.test(st))
			{
				 System.out.println(st.name + " : " + st.marks);
			}
		}
	}

	
}
