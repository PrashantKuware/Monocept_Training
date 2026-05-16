package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.model.Course;
import com.studentcourse.util.DBConnection;

public class CourseDAO 
{
	public List<Course> getAllCourse() throws Exception
	{
		String sqlQuery = "select * from courses";
	    List<Course> courses = new ArrayList<>();

	    try(Connection connection = DBConnection.getConnection();
		         PreparedStatement statement = connection.prepareStatement(sqlQuery);
		         ResultSet resultSet = statement.executeQuery())
	    {

	        while(resultSet.next())
	        {
	        	Course course = new Course(
	            		resultSet.getString("course_name"),
	            		resultSet.getString("duration"),
	            		resultSet.getInt("course_id"),
	            		resultSet.getDouble("fees"),
	            		resultSet.getString("trainer_name")
	                    );

	        	courses.add(course);
	        }
	    }
	    catch(SQLException e)
	    {
	        System.out.println( e.getMessage());
	    }

	    return courses;
	}
	
	// 2. Insert a new course record into the course table.

			public int inserNewCourse(String courseName, int tempDuration, int tempFees, String trainerName) throws Exception 
			{
				String sqlQuery2 = "insert into courses (course_name, duration, fees, trainer_name) values (?,?,?,?)";
				int count = 0;
				try(Connection connection = DBConnection.getConnection();
		        PreparedStatement statement2 = connection.prepareStatement(sqlQuery2))
				{

					statement2.setString(1, courseName);
					statement2.setInt(2, tempDuration);
					statement2.setInt(3, tempFees);
					statement2.setString(4, trainerName);

					count = statement2.executeUpdate();

				} 
				catch (SQLException e) 
				{
					System.out.println(e.getMessage());
				}
				return count;
			}

			// 3. Update the course using their course name.

			public int UpdateCourse( String courseName, int tempDuration, int tempFees, String trainerName) throws Exception 
			{
				String sqlQuery8 = "update courses set duration = ?, fees=?, trainer_name=? where course_name = ?";
				int count = 0;
				try (Connection connection = DBConnection.getConnection();
						PreparedStatement statement8 = connection.prepareStatement(sqlQuery8)) 
				{
					statement8.setInt(1, tempDuration);
					statement8.setInt(2, tempFees);
					statement8.setString(3, trainerName);
					statement8.setString(4, courseName);

					count=statement8.executeUpdate();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				return count;
			}

			// 4. Delete a course record using their name.

			public int deleteCourseRecord(String courseName) throws Exception 
			{
				String sqlQuery10 = "delete from courses where course_name=?";
				int count = 0;
				try (Connection connection = DBConnection.getConnection();
						PreparedStatement statement10 = connection.prepareStatement(sqlQuery10)) 
				{
					statement10.setString(1, courseName);
					count=statement10.executeUpdate();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				return count;
			}
			
			// 4. check course is available or not.

			public Course checkCourseAvailability(String courseName) throws Exception 
			{
				String sqlQuery10 = "select * from courses where course_name=?";
				
				try (Connection connection = DBConnection.getConnection();
						PreparedStatement statement = connection.prepareStatement(sqlQuery10)) 
				{
					statement.setString(1, courseName);
					ResultSet resultSet = statement.executeQuery();

		            if (resultSet.next()) 
		            {
		                return new Course(
		                		resultSet.getString("course_name"),
			            		resultSet.getString("duration"),
			            		resultSet.getInt("course_id"),
			            		resultSet.getDouble("fees"),
			            		resultSet.getString("trainer_name"));
		            } 
				}
		            catch (SQLException e) 
		            {
		            	e.printStackTrace();
		            }
				return null;
				}

			public boolean checkDuplicateCourse(String courseName) throws Exception 
			{

				String query = "select * from courses " +
					    "where course_name=? " ;

					    try(Connection connection = DBConnection.getConnection();
					    		PreparedStatement statement =connection.prepareStatement(query))
					    {
					        statement.setString(1, courseName);

					        ResultSet resultSet = statement.executeQuery();

					        return resultSet.next();
					    }
			}	
}

