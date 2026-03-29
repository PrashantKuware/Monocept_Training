package com.exceptionHandling.testing;

import java.util.Scanner;


class InvalidMarksException extends Exception {
 public InvalidMarksException(String message) {
     super(message);
 }
}

class StudentGrading {

 public static void processStudent(String name, int marks)
         throws InvalidMarksException {

     try {

         
         if (name == null || name.isEmpty()) {
             throw new NullPointerException("Student name cannot be null or empty");
         }

        
         if (marks < 0 || marks > 100) {
             throw new InvalidMarksException("Marks must be between 0 and 100");
         }

      
         String grade;
         if (marks >= 90) grade = "A";
         else if (marks >= 75) grade = "B";
         else if (marks >= 50) grade = "C";
         else grade = "Fail";

         System.out.println("Student Name: " + name);
         System.out.println("Marks: " + marks);
         System.out.println("Grade: " + grade);

     } finally {
         System.out.println("Grading process completed");
     }
 }
}

public class studentGradingSystem {

 public static void main(String[] args) {

     Scanner scanner = new Scanner(System.in);

     try {

         System.out.print("Enter student name: ");
         String name = scanner.nextLine().trim();

         System.out.print("Enter marks: ");
         int marks = scanner.nextInt();

         StudentGrading.processStudent(name, marks);

     } catch (InvalidMarksException e) {
         System.out.println("Custom Exception: " + e.getMessage());

     } catch (NullPointerException e) {
         System.out.println("Null Error: " + e.getMessage());

     } catch (Exception e) {
         System.out.println("Invalid input type! Please enter correct data.");
     } finally {
         scanner.close();
     }
 }
}