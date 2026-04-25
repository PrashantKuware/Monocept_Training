package com.java.assignments.student_management_system.model;

public class Registration {
    private int regId;
    private int studentId;
    private String courseName;
    private double feesPaid;

    public Registration(int regId, int studentId, String courseName, double feesPaid) 
    {
        this.regId = regId;
        this.studentId = studentId;
        this.courseName = courseName;
        this.feesPaid = feesPaid;
    }

    public int getRegId() { return regId; }
    public int getStudentId() { return studentId; }
    public String getCourseName() { return courseName; }
    public double getFeesPaid() { return feesPaid; }
}