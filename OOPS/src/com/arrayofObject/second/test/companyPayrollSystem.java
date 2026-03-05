package com.arrayofObject.second.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class companyPayrollSystem {

	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        List<Employee> empList = new ArrayList<>();

	        String choice;

	        do {
	            System.out.println("Select Employee Type:");
	            System.out.println("1. Full Time");
	            System.out.println("2. Part Time");
	            System.out.println("3. Intern");

	            int type = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Enter Employee ID: ");
	            int id = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Enter Employee Name: ");
	            String name = sc.nextLine();

	            Employee emp = null;

	            switch (type) {
	                case 1:
	                    System.out.print("Enter Monthly Salary: ");
	                    double salary = sc.nextDouble();

	                    System.out.print("Enter Bonus: ");
	                    double bonus = sc.nextDouble();

	                    emp = new FullTimeEmployee(id, name, salary, bonus);
	                    break;

	                case 2:
	                    System.out.print("Enter Hours Worked: ");
	                    int hours = sc.nextInt();

	                    System.out.print("Enter Hourly Rate: ");
	                    double rate = sc.nextDouble();

	                    emp = new PartTimeEmployee(id, name, hours, rate);
	                    break;

	                case 3:
	                    System.out.print("Enter Stipend: ");
	                    double stipend = sc.nextDouble();

	                    emp = new Intern(id, name, stipend);
	                    break;

	                default:
	                    System.out.println("Invalid type!");
	            }

	            if (emp != null) {
	                empList.add(emp);
	            }

	            sc.nextLine();
	            System.out.print("Add another employee? (yes/no): ");
	            choice = sc.nextLine();

	        } while (choice.equalsIgnoreCase("yes"));

	        
	        Employee[] employees = empList.toArray(new Employee[0]);

	        System.out.println("\n---- Employee Salaries ----");

	        for (Employee e : employees) {
	            e.display();  
	        }

	        System.out.println("Total Employees Created: "
	                + Employee.getTotalEmployees());

	        sc.close();
	    }
	

}
