package com.java.assignments.student_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.assignments.student_management_system.util.DBUtil;

public class RegistrationDAO 
{

    public boolean isAlreadyRegistered(Connection connection, int id, String course) throws Exception 
    {
        String sqlQuery = "SELECT * FROM registration WHERE student_id=? AND course_name=?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) 
        {
            statement.setInt(1, id);
            statement.setString(2, course);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }

    public void addRegistration(Connection connection, int id, String course, double fee) throws Exception 
    {
        String sqlQuery = "INSERT INTO registration(student_id, course_name, fees_paid) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) 
        {
            statement.setInt(1, id);
            statement.setString(2, course);
            statement.setDouble(3, fee);
            statement.executeUpdate();
        }
    }

    public boolean updateFee(int id, String course, double fee) 
    {
        String sqlQuery = "UPDATE registration SET fees_paid=? WHERE student_id=? AND course_name=?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) 
        {

            statement.setDouble(1, fee);
            statement.setInt(2, id);
            statement.setString(3, course);

            return statement.executeUpdate() > 0;

        }
        catch (Exception e) 
        {
            return false;
        }
    }

    public boolean deleteRegistration(int id, String course) 
    {
        String sqlQuery = "DELETE FROM registration WHERE student_id=? AND course_name=?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) 
        {

            statement.setInt(1, id);
            statement.setString(2, course);

            return statement.executeUpdate() > 0;

        } 
        catch (Exception e) 
        {
            return false;
        }
    }

    public boolean deleteAllByStudent(Connection connection, int id) throws Exception 
    {
        String sqlQuery = "DELETE FROM registration WHERE student_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) 
        {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        }
    }

    public List<String> getAllStudentsWithCourses() 
    {
        List<String> list = new ArrayList<>();

        String sqlQuery = """
                SELECT s.id, s.name, s.branch, r.course_name, r.fees_paid
                FROM student s
                LEFT JOIN registration r
                ON s.id = r.student_id
                """;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = statement.executeQuery()) 
        {

            while (resultSet.next()) 
            {
                list.add(
                        resultSet.getInt("id") + " | " +
                        resultSet.getString("name") + " | " +
                        resultSet.getString("branch") + " | " +
                        resultSet.getString("course_name") + " | " +
                        resultSet.getDouble("fees_paid"));
            }

        } 
        catch (Exception e) {}
        return list;
    }

    public List<String> getRegistrationsByStudentId(int id) {
        List<String> list = new ArrayList<>();

        String sqlQuery = "SELECT course_name, fees_paid FROM registration WHERE student_id=?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) 
        {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) 
            {
                list.add(resultSet.getString("course_name") + " -> " + resultSet.getDouble("fees_paid"));
            }

        } catch (Exception e) {}
        return list;
    }

    public Map<String, Integer> getCourseWiseCount() 
    {
        Map<String, Integer> map = new HashMap<>();

        String sqlQuery = "SELECT course_name, COUNT(*) as total FROM registration GROUP BY course_name";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = statement.executeQuery()) 
        {

            while (resultSet.next()) 
            {
                map.put(resultSet.getString("course_name"), resultSet.getInt("total"));
            }

        }
        catch (Exception e) {}
        return map;
    }
}