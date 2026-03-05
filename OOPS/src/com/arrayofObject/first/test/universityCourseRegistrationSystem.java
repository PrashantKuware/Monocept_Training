package com.arrayofObject.first.test;
import com.arrayofObject.first.model.*;
import java.util.Scanner;

public class universityCourseRegistrationSystem {

	public static void main(String[] args) {
		int collegeId, studentChoice;
		int noOfSubject;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your Id");
		while(!scanner.hasNextInt())
		{
			System.out.println("Enter valid id in numbers");
			scanner.nextLine();
			continue;
		}
		collegeId = scanner.nextInt();
		
		System.out.println("What course do you want to choose");
		System.out.println("Press 1 for Online Course");
		System.out.println("Press 2 for Regular Course");
		while(!scanner.hasNextInt())
		{
			System.out.println("Enter valid id in numbers");
			scanner.nextLine();
			continue;
		}
		studentChoice = scanner.nextInt();
		
		System.out.println("How many Subject do you want to choose");
		
		while(true)
		{
			 System.out.println("Enter a number between 1 and 5:");
			 if (!scanner.hasNextInt()) {
	                System.out.println("Error: Please enter a valid integer.");
	                scanner.nextLine(); // clear invalid input
	                continue;
	            }
			 noOfSubject = scanner.nextInt();
			 scanner.nextLine(); // clear buffer
			 
			 if (noOfSubject < 1 || noOfSubject > 5) {
	                System.out.println("Error: Number must be between 1 and 5.");
	                continue;
	            }
			 break;
		}
		
		Course[] courses = new Course[noOfSubject];
		for(int i=0;i<=noOfSubject-1;i++)
		{
			System.out.println("Enter Course Id");
			while(!scanner.hasNextInt())
			{
				System.out.println("Enter valid id in numbers only");
				scanner.nextLine();
				continue;
			}
			 long id = scanner.nextInt();
			 scanner.nextLine();
			 
			 System.out.println("Enter Course name");
				while(!scanner.hasNextLine())
				{
					System.out.println("Enter valid id in numbers only");
					scanner.nextLine();
					continue;
				}
				 String courseName = scanner.nextLine();
				 scanner.nextLine();
				 
				 System.out.println("Enter base fees");
					while(!scanner.hasNextInt())
					{
						System.out.println("Enter valid id in numbers only");
						scanner.nextLine();
						continue;
					}
					 double baseFees = scanner.nextDouble();
					 scanner.nextLine();
					 
					 courses[i] = new RegularCourse(id, courseName, baseFees);
		}
		 for (Course c : courses) 
		 {
	            c.displayCourses(); 
	     }

	        System.out.println("Total Courses Created: " +
	                           Course.getTotalCourses());
	}

}
