package com.java.assignments.student_management_system.model;

public class Branch {
    int id;
    public String name;
    int deptId;

    public Branch(int id, String name, int deptId) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
    }
}