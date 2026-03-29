package com.Inheritance.second.model;

public abstract class Employee {

    protected int empId;
    protected String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public abstract double calculateSalary();

    public void displayEmployee() {
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Salary        : " + calculateSalary());
        System.out.println("------------------------------");
    }
}
