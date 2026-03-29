package com.ComparatorAndComparable.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


 class Student 
{
	
	private String name;
	private String  age;
	
//	@Override
//	public int compareTo(Student o) {

//		return this.rollNo-o.rollNo;
//	}
	
	Student( String name, String age)
	{
		
		this.name = name;
		this.age = age;
	}
	
	
	public String getName()
	{
		return name;
	}
	public String getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return "Candidate { "+ "Name : " + name +", " + "Age : "+age +"}";
	}

	
}

 class candidate 
{
	 
	
	public static void main(String[] args)
	{
		ArrayList<Student> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		String name = null, age;
		int sortingChoice ;
		
		
		while(true)
		{
			while(true)
			{
				System.out.println("Enter the name");
				name = scanner.nextLine().trim();
				if(!name.matches("[a-zA-Z]+"))
				{
					System.out.println("Name is incorrect");
					continue;
				}
				break;
			}
			while(true)
			{
				System.out.println("Enter the age");
				age = scanner.nextLine().trim();
				if(!age.matches("\\d+"))
				{
					System.out.println("Age is incorrect");
					continue;
				}
				break;
			}	
				
				list.add(new Student(name,age));
				
				 System.out.print("Add more students? (yes/no): ");
		            String choice = scanner.nextLine();

		            if(choice.equalsIgnoreCase("no"))
		                break;
			
		}
		
		while(true)
		{
			System.out.println("Enter choice for sorting");
			System.out.println("1 for name sorting");
			System.out.println("2 for age sorting");
			sortingChoice = scanner.nextInt();
			if(sortingChoice == 1 || sortingChoice == 2)
			{
				break;
			}
			System.out.println("Incorrect choice. choose either 1 or 2");
		}
		
		switch(sortingChoice)
		{
		case 1 :
			Collections.sort(list, new nameComparator());
			break;
		case 2 :
			Collections.sort(list, new ageComparator());
			break;
		}
		
		
	
		for(Student st : list)
		{
			System.out.println(st);	
		}
		
		

	}
	
}
