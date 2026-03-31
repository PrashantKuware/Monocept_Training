package assigment1.map;

import java.util.Arrays;
import java.util.List;

public class fourth 
{
	static class Person
	{
		String name;
		char gender;
		
		Person(String name, char gender)
		{
			this.name=name;
			this.gender=gender;
		}
	}

	public static void main(String[] args)
	{
		List<Person> list = Arrays.asList(
				new Person("Prashant", 'M'),
				new Person("Aman", 'M'),
				new Person("Arti", 'F'),
				new Person("Asus", 'M'),
				new Person("Roshni", 'F')
				);
		
		list.stream().map(p -> {
			if(p.gender == 'F') return "Ms."+p.name;
			else 
				return "Mr."+p.name;
		}).forEach(p -> System.out.println(p));
	}

}
