package String;

import java.util.Arrays;

public class StudentTest 
{
	public static void main(String[] args)
	{
		Student student = new Student();
		
		System.out.println(Arrays.toString(student.getMarks()));
		student.getMarks()[0] = 800;
		System.out.println(Arrays.toString(student.getMarks()));
	}
}
