package com.studentcourse.model;

public class Registration 
{
		private int registration_id;
	    private int student_id;
	    private int course_id;
	    private String date;
	    private String status;

	    public Registration(int registration_id,
	    				int student_id,
	                   int course_id,
	                   String date,
	                   String status)
	    {
	        this.registration_id = registration_id;
	        this.student_id = student_id;
	        this.course_id = course_id;
	        this.date = date;
	        this.status = status;
	    }

	    public int getRegId()
	    {
	        return registration_id;
	    }

	    public int getStudentId()
	    {
	        return student_id;
	    }

	    public int getCourseId()
	    {
	        return course_id;
	    }

	    public String getdate()
	    {
	        return date;
	    }

	    public String getStatus()
	    {
	        return status;
	    }
}
