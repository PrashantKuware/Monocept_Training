package com.arrayofObject.second.model;

public abstract class Employee 
{

    protected int empId;
    protected String empName;

    protected static int totalEmployees = 0;

    public Employee(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
        totalEmployees++;
    }

    // Method overloading
    public double calculateSalary() {
        return 0;
    }

    public double calculateSalary(double amount) {
        return amount;
    }

    // Abstract method (polymorphism)
    public abstract double calculateSalaryFinal();

    public void display() {
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.println("Salary        : " + calculateSalaryFinal());
        System.out.println("-----------------------------");
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }
}