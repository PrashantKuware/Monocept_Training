package com.studentcourse.model;

public class Course 
{
	private String course_name;
    private String duration;
    private int course_id;
    private  double fees;
    private  String trainer_name;

    public Course(String course_name,
    				String duration,
                   int course_id,
                   double fees,
                   String trainer_name)
    {
        this.course_name = course_name;
        this.duration = duration;
        this.course_id = course_id;
        this.fees = fees;
        this.trainer_name = trainer_name;
    }

    public String getCourseName()
    {
        return course_name;
    }

    public String getDuration()
    {
        return duration;
    }

    public int getCourseId()
    {
        return course_id;
    }

    public double getFees()
    {
        return fees;
    }

    public String getTrainer()
    {
        return trainer_name;
    }
}
