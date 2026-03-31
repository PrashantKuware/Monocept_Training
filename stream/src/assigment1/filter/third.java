package assigment1.filter;

import java.util.Arrays;
import java.util.List;

class Student
{
	int id;
	String name;
	int marks;
	
	Student(int id, String name, int marks)
	{
		this.id=id;
		this.name=name;
		this.marks=marks;
	}
}

public class third 
{

	public static void main(String[] args) 
	{
		List<Student> student = Arrays.asList(
				new Student(101, "Aman", 89),
				new Student(102, "Ram", 45),
				new Student(103, "Prashant",75),
				new Student(104, "Asus", 38),
				new Student(105, "Laptop", 97)
				);

		student.stream().filter(st -> st.marks>=60).forEach(n -> System.out.println("ID : "+n.id+", Name : "+n.name+", Marks : "+n.marks));
	}

}
