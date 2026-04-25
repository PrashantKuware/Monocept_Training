package com.java.assignments.student_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.assignments.student_management_system.model.Student;
import com.java.assignments.student_management_system.util.DBUtil;

public class StudentDAO 
{

    public boolean addStudent(Student s) 
    {
        String sqlQuery = "INSERT INTO student VALUES (?, ?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) 
        {

            statement.setInt(1, s.getId());
            statement.setString(2, s.getName());
            statement.setInt(3, s.getAge());
            statement.setString(4, s.getBranch());

            return statement.executeUpdate() > 0;

        } 
        catch (Exception e) 
        {
            return false;
        }
    }

    public Student getStudentById(int id) 
    {
        String sqlQuery = "SELECT * FROM student WHERE id=?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery))
{

        	statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) 
            {
                return new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("branch"));
            }

        } 
        catch (Exception e) {}
        return null;
    }

    public boolean updateStudent(int id, String name, String branch) 
    {
        String sqlQuery = "UPDATE student SET name=?, branch=? WHERE id=?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) 
        {

        	statement.setString(1, name);
        	statement.setString(2, branch);
        	statement.setInt(3, id);

            return statement.executeUpdate() > 0;

        } 
        catch (Exception e) 
        {
            return false;
        }
    }

    public boolean deleteStudent(Connection con, int id) throws Exception 
    {
        String sqlQuery = "DELETE FROM student WHERE id=?";
        try (PreparedStatement statement = con.prepareStatement(sqlQuery)) 
        {
        	statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    public List<String> getHighPayingStudents() 
    {
        List<String> list = new ArrayList<>();

        String sqlQuery = """
                SELECT s.name, r.fees_paid, r.course_name, s.branch
                FROM student s
                JOIN registration r
                ON s.id = r.student_id
                ORDER BY r.fees_paid DESC
                """;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) 
        {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) 
            {
                list.add(resultSet.getString("name") + " -> " + resultSet.getDouble("fees_paid"));
            }

        } 
        catch (Exception e) {}
        return list;
    }
}