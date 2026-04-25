package com.java.assignments.student_management_system.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.assignments.student_management_system.dao.BranchDAO;
import com.java.assignments.student_management_system.dao.CourseDAO;
import com.java.assignments.student_management_system.dao.DepartmentDAO;
import com.java.assignments.student_management_system.dao.RegistrationDAO;
import com.java.assignments.student_management_system.dao.StudentDAO;
import com.java.assignments.student_management_system.model.Branch;
import com.java.assignments.student_management_system.model.Course;
import com.java.assignments.student_management_system.model.Department;
import com.java.assignments.student_management_system.model.Student;
import com.java.assignments.student_management_system.util.DBUtil;
import com.java.assignments.student_management_system.validation.AppliedValidation;

public class StudentService 
{

    StudentDAO studentDAO = new StudentDAO();
    RegistrationDAO registrationDAO = new RegistrationDAO();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    BranchDAO branchDAO = new BranchDAO();
    CourseDAO courseDAO = new CourseDAO();
    
    public void addStudent(Student s) 
    {
        if (s.getId() <= 0 || s.getName().isEmpty() || s.getAge() <= 0) 
        {
            System.out.println("Invalid input");
            return;
        }

        if (studentDAO.getStudentById(s.getId()) != null) 
        {
            System.out.println("Duplicate ID");
            return;
        }

        studentDAO.addStudent(s);
        System.out.println("Student added");
    }

    public void registerCourse(int id, String course, double fee) {
        if (fee <= 0) {
            System.out.println("Invalid fee");
            return;
        }

        try (Connection connection = DBUtil.getConnection()) 
        {

            if (studentDAO.getStudentById(id) == null) 
            {
                System.out.println("Student not found");
                return;
            }

            connection.setAutoCommit(false);

            if (registrationDAO.isAlreadyRegistered(connection, id, course)) 
            {
                System.out.println("Duplicate registration");
                connection.rollback();
                return;
            }

            registrationDAO.addRegistration(connection, id, course, fee);

            connection.commit();
            System.out.println("Registered successfully");

        } 
        catch (Exception e) 
        {
            System.out.println("Transaction failed");
        }
    }

    public void viewAllStudentsWithCourses() 
    {
        List<String> list = registrationDAO.getAllStudentsWithCourses();
        if (list.isEmpty()) System.out.println("No data");
        else list.forEach(System.out::println);
    }

    public void searchStudentById(int id) 
    {
        Student student = studentDAO.getStudentById(id);

        if (student == null) 
        {
            System.out.println("Student not found");
            return;
        }

        System.out.println(student.getName());

        List<String> courses = registrationDAO.getRegistrationsByStudentId(id);
        if (courses.isEmpty()) System.out.println("No courses");
        else courses.forEach(System.out::println);
    }

    public void updateStudent(int id, String name, String branch) 
    {
        if (studentDAO.getStudentById(id) == null) 
        {
            System.out.println("Student not found");
            return;
        }

        if (studentDAO.updateStudent(id, name, branch))
            System.out.println("Updated");
        else
            System.out.println("Failed");
    }

    public void updateCourseFee(int id, String course, double fee) 
    {
        if (fee <= 0) 
        {
            System.out.println("Invalid fee");
            return;
        }

        if (registrationDAO.updateFee(id, course, fee))
            System.out.println("Updated");
        else
            System.out.println("Failed");
    }

    public void cancelRegistration(int id, String course) 
    {
        if (registrationDAO.deleteRegistration(id, course))
            System.out.println("Cancelled");
        else
            System.out.println("Failed");
    }

    public void deleteStudent(int id) 
    {
        try (Connection connection = DBUtil.getConnection()) 
        {

            connection.setAutoCommit(false);

            registrationDAO.deleteAllByStudent(connection, id);
            studentDAO.deleteStudent(connection, id);

            connection.commit();
            System.out.println("Student Permanently Deleted");

        } 
        catch (Exception e) 
        {
            System.out.println("Rollback");
        }
    }

    public void showHighPayingStudents() 
    {
        List<String> list = studentDAO.getHighPayingStudents();
        if (list.isEmpty()) System.out.println("No data");
        else list.forEach(System.out::println);
    }

    public void showCourseWiseCount() 
    {
        Map<String, Integer> map = registrationDAO.getCourseWiseCount();
        if (map.isEmpty()) System.out.println("No data");
        else map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
    
    public String selectCourseHierarchy(Scanner scanner) {

        // ================== STEP 1: COURSE ==================
        List<Course> courses = courseDAO.getAllCourses();

        if (courses.isEmpty()) {
            System.out.println("❌ No courses available.");
            return null;
        }

        Course selectedCourse = null;

        while (true) {
            System.out.println("\nSelect Course:");
            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ". " + courses.get(i).name);
            }

            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= courses.size()) {
                    selectedCourse = courses.get(choice - 1);
                    break;
                } else {
                    System.out.println(" Invalid choice. Try again.");
                }
            } else {
                System.out.println("Please enter a number.");
                scanner.nextLine();
            }
        }

        // ================== STEP 2: DEPARTMENT ==================
        List<Department> depts = departmentDAO.getAllDepartments();

        if (depts.isEmpty()) {
            System.out.println(" No departments available.");
            return null;
        }

        Department selectedDept = null;

        while (true) {
            System.out.println("\nSelect Department:");
            for (int i = 0; i < depts.size(); i++) {
                System.out.println((i + 1) + ". " + depts.get(i).name);
            }

            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= depts.size()) {
                    selectedDept = depts.get(choice - 1);
                    break;
                } else {
                    System.out.println(" Invalid choice. Try again.");
                }
            } else {
                System.out.println(" Please enter a number.");
                scanner.nextLine();
            }
        }

        // ================== STEP 3: BRANCH ==================
        List<Branch> branches = branchDAO.getBranchesByDept(selectedDept.id);

        if (branches.isEmpty()) {
            System.out.println(" No branches available for this department.");
            return null;
        }

        Branch selectedBranch = null;

        while (true) {
            System.out.println("\nSelect Branch:");
            for (int i = 0; i < branches.size(); i++) {
                System.out.println((i + 1) + ". " + branches.get(i).name);
            }

            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= branches.size()) {
                    selectedBranch = branches.get(choice - 1);
                    break;
                } else {
                    System.out.println(" Invalid choice. Try again.");
                }
            } else {
                System.out.println(" Please enter a number.");
                scanner.nextLine();
            }
        }

        // ================== FINAL RESULT ==================
        return selectedCourse.name + " - " +
               selectedDept.name + " - " +
               selectedBranch.name;
    }
    
    public String selectBranch(Scanner scanner) {

        // Step 1: Show Departments
        List<Department> department = departmentDAO.getAllDepartments();

        System.out.println("\nSelect Department:");
        for (int i = 0; i < department.size(); i++) 
        {
            System.out.println((i + 1) + ". " + department.get(i).name);
        }

        int deptChoice = AppliedValidation.idValidation(scanner);
        
        if (deptChoice < 1 || deptChoice > department.size()) 
        {
            System.out.println("Invalid choice");
            return selectBranch(scanner);
        }
        
        Department selectedDept = department.get(deptChoice - 1);

        // Step 2: Show Branches
        List<Branch> branches = branchDAO.getBranchesByDept(selectedDept.id);

        System.out.println("\nSelect Branch:");
        for (int i = 0; i < branches.size(); i++) {
            System.out.println((i + 1) + ". " + branches.get(i).name);
        }

        int branchChoice = scanner.nextInt();
        scanner.nextLine();

        return branches.get(branchChoice - 1).name;
    }
    
    public void showBranches() 
    {
        List<Branch> list = branchDAO.getAllBranches();

        if (list.isEmpty()) 
        {
            System.out.println("No branches available");
            return;
        }

        list.forEach(b -> System.out.println(b.id + " - " + b.name));
    }
    
    public void showCourses() {
        List<Course> list = courseDAO.getAllCourses();

        if (list.isEmpty()) {
            System.out.println("No courses available");
            return;
        }

        list.forEach(c -> System.out.println(c.id + " - " + c.name));
    }
    
    public void addBranch(Scanner sc) {

        List<Department> depts = departmentDAO.getAllDepartments();

        if (depts.isEmpty()) {
            System.out.println("No departments available");
            return;
        }

        System.out.println("Select Department:");
        for (int i = 0; i < depts.size(); i++) {
            System.out.println((i + 1) + ". " + depts.get(i).name);
        }

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > depts.size()) 
        {
            System.out.println("Invalid choice");
            return;
        }

        System.out.print("Enter Branch Name: ");
        String name = sc.nextLine();

        if (branchDAO.addBranch(name, depts.get(choice - 1).id))
            System.out.println("Branch added");
        else
            System.out.println("Failed");
    }
    
    public void addDepartment(String name) {
        if (name.isEmpty()) {
            System.out.println("Invalid department name");
            return;
        }

        if (departmentDAO.addDepartment(name))
            System.out.println("Department added");
        else
            System.out.println("Failed");
    }
    
    public void addCourse(String name) {
        if (name.isEmpty()) {
            System.out.println("Invalid course name");
            return;
        }

        if (courseDAO.addCourse(name))
            System.out.println("Course added");
        else
            System.out.println("Failed");
    }
}