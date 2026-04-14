package streamTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;


class Student
{
	int marks;
	String name;
	
	Student(int marks, String name)
	{
		this.marks=marks;
		this.name=name;
	}
	@Override
	public String toString() {
	    return "Marks: " + marks + ", Name: " + name;
	}
}

 class constructorReference
{

	public static void main(String[] args) 
	{
		BiFunction<Integer, String, Student> fun = Student::new;
		List<Student> list = new ArrayList<>();
		list.add(fun.apply(56, "Ram"));
		list.add(fun.apply(89, "Sham"));
		list.add(fun.apply(90, "Mouse"));
		
		list.forEach(System.out::println);
//		System.out.println(list.get(0).getClass());
		list.forEach(s -> System.out.println("Marks: " + s.marks + ", Name: " + s.name));
	}
	

}
