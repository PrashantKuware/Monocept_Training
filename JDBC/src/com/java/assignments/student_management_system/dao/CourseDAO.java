package com.java.assignments.student_management_system.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.assignments.student_management_system.model.Course;
import com.java.assignments.student_management_system.util.DBUtil;
import java.sql.Connection;

public class CourseDAO 
{

    public boolean addCourse(String name) 
    {
        String sqlQuery = "INSERT INTO course(course_name) VALUES (?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) 
        {

            statement.setString(1, name);
            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public List<Course> getAllCourses() 
    {
        List<Course> list = new ArrayList<>();
        String sqlQuery = "SELECT * FROM course";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                list.add(new Course(
                        resultSet.getInt("course_id"),
                        resultSet.getString("course_name")));
            }

        } catch (Exception e) {}

        return list;
    }
}