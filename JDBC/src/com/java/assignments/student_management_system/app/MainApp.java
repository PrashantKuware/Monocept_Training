package com.java.assignments.student_management_system.app;

import java.util.Scanner;

import com.java.assignments.student_management_system.model.Student;
import com.java.assignments.student_management_system.service.StudentService;
import com.java.assignments.student_management_system.validation.AppliedValidation;

public class MainApp 
{

    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) 
        {

            System.out.println("\n===== MENU =====\n");
            System.out.println("1. Add Student");
            System.out.println("2. Register for Course");
            System.out.println("3. View All Students with Courses");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Update Student");
            System.out.println("6. Update Course Fee");
            System.out.println("7. Cancel Registration");
            System.out.println("8. Delete Student");
            System.out.println("9. High Paying Students Report");
            System.out.println("10. Course-wise Student Count");
            System.out.println("11. Exit");
            
            System.out.print("\nEnter your choice: ");
           
            int choice = 0;
			try 
			{
				choice = AppliedValidation.validateChoice(scanner);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
            

            switch (choice) 
            {

                case 1 ->
                {
                    System.out.print("Enter Student ID: ");
                    int id = AppliedValidation.idValidation(scanner);

                    System.out.print("Enter Name: ");
                    String name = AppliedValidation.stringValidation(scanner);

                    System.out.print("Enter Age: ");
                    int age = AppliedValidation.ageValidation(scanner);

                    System.out.println();
                    String branch = service.selectBranch(scanner);

                    service.addStudent(new Student(id, name, age, branch));
                }

                case 2 ->
                {
                    System.out.print("Enter Student ID: ");
                    int id = AppliedValidation.idValidation(scanner);

                    System.out.print("Enter Course Name: ");
//                    String course = AppliedValidation.stringValidation(scanner);
                    String course = service.selectCourseHierarchy(scanner);

                    System.out.print("Enter Fee: ");
                    double fee = AppliedValidation.feesValidation(scanner);

                    service.registerCourse(id, course, fee);
                }

                case 3 -> 
                {
                	service.viewAllStudentsWithCourses();
                }

                case 4 -> 
                {
                    System.out.print("Enter Student ID: ");
                    int id = AppliedValidation.idValidation(scanner);

                    service.searchStudentById(id);
                }

                case 5 ->
                {
                    System.out.print("Enter Student ID: ");
                    int id = AppliedValidation.idValidation(scanner);

                    System.out.print("Enter New Name: ");
                    String name = AppliedValidation.stringValidation(scanner);

                    System.out.print("Enter New Branch: ");
                    String branch = AppliedValidation.stringValidation(scanner);

                    service.updateStudent(id, name, branch);
                }

                case 6 ->
                {
                    System.out.print("Enter Student ID: ");
                    int id = AppliedValidation.idValidation(scanner);

                    System.out.print("Enter Course Name: ");
                    String course = AppliedValidation.stringValidation(scanner);

                    System.out.print("Enter New Fee: ");
                    double fee = AppliedValidation.feesValidation(scanner);

                    service.updateCourseFee(id, course, fee);
                }

                case 7 ->
                {
                    System.out.print("Enter Student ID: ");
                    int id = AppliedValidation.idValidation(scanner);

                    System.out.print("Enter Course Name: ");
                    String course = AppliedValidation.stringValidation(scanner);

                    service.cancelRegistration(id, course);
                }

                case 8 ->
                {
                    System.out.print("Enter Student ID: ");
                    int id = AppliedValidation.idValidation(scanner);

                    service.deleteStudent(id);
                }

                case 9 -> 
                {
            
                    service.showHighPayingStudents();
                }

                case 10 -> 
                {
                	service.showCourseWiseCount();
                }

                case 11 ->
                {
                    System.out.println("Exit Successfully");
                    scanner.close();
                    return;
                }

                default -> System.out.println(" Invalid choice");
            }
        }
    }
}