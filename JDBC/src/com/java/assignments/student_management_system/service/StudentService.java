package com.java.assignments.student_management_system.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.assignments.student_management_system.dao.BranchDAO;
import com.java.assignments.student_management_system.dao.DepartmentDAO;
import com.java.assignments.student_management_system.dao.RegistrationDAO;
import com.java.assignments.student_management_system.dao.StudentDAO;
import com.java.assignments.student_management_system.model.Branch;
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
    
    public String selectCourseHierarchy(Scanner scanner) 
    {

        // Step 1: Course selection
        System.out.println("Select Course:");
        System.out.println("1. BTech");
        System.out.println("2. BSc");

        int courseChoice = scanner.nextInt();
        scanner.nextLine();

        String course = (courseChoice == 1) ? "BTech" : "BSc";

        // Step 2: Department selection
        List<Department> depts = departmentDAO.getAllDepartments();

        System.out.println("\nSelect Department:");
        for (int i = 0; i < depts.size(); i++) {
            System.out.println((i + 1) + ". " + depts.get(i).name);
        }

        int deptChoice = scanner.nextInt();
        scanner.nextLine();

        Department selectedDept = depts.get(deptChoice - 1);

        // Step 3: Branch selection
        List<Branch> branches = branchDAO.getBranchesByDept(selectedDept.id);

        System.out.println("\nSelect Branch:");
        for (int i = 0; i < branches.size(); i++) {
            System.out.println((i + 1) + ". " + branches.get(i).name);
        }

        int branchChoice = scanner.nextInt();
        scanner.nextLine();

        Branch selectedBranch = branches.get(branchChoice - 1);

        // Final course string
        return course + " - " + selectedDept.name + " - " + selectedBranch.name;
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
}