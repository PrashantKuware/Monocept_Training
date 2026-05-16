package com.studentcourse.model;

public class Registration
{
    private int registrationId;
    private int studentId;
    private int courseId;

    private String studentName;
    private String courseName;

    private String registrationDate;
    private String status;

    public Registration(
    	    int registrationId,
    	    int studentId,
    	    int courseId,
    	    String registrationDate,
    	    String studentName,
    	    String courseName,
    	    String status)
    {
        this.registrationId = registrationId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.registrationDate = registrationDate;
        this.studentName = studentName;
        this.courseName = courseName;
        this.status = status;
    }

    public int getRegistrationId()
    {
        return registrationId;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public int getCourseId()
    {
        return courseId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public String getRegistrationDate()
    {
        return registrationDate;
    }

    public String getStatus()
    {
        return status;
    }
}