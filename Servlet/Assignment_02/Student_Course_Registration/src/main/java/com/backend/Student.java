package com.backend;

public class Student
{
    private String name;
    private String email;
    private int age;
    private String course;
    private String batch;

    public Student(String name,
                   String email,
                   int age,
                   String course,
                   String batch)
    {
        this.name = name;
        this.email = email;
        this.age = age;
        this.course = course;
        this.batch = batch;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public int getAge()
    {
        return age;
    }

    public String getCourse()
    {
        return course;
    }

    public String getBatch()
    {
        return batch;
    }
}