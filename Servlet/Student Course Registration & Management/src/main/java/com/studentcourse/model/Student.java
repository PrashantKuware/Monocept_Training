package com.studentcourse.model;

public class Student
{
    private String name;
    private String email;
    private int age;
    private String city;
    private String phone;
    private int id;

    public Student(int id, String name, String email, String phone, int age, String city)
    {
        this.name = name;
        this.email = email;
        this.age = age;
        this.city = city;
        this.phone = phone;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    
    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public int getAge()
    {
        return age;
    }

    public String getCity()
    {
        return city;
    }

    public int getid()
    {
        return id;
    }
}