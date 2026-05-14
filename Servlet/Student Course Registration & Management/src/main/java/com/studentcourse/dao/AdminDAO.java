package com.studentcourse.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.studentcourse.model.Admin;
import com.studentcourse.util.DBConnection;


public class AdminDAO 
{
	
	public Admin loginAdmin(String username, String password)
	{
		String sqlQuery = "select * from admin " + "where username=? " + "and password=?";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(sqlQuery))
		{
			statement.setString(1, username);

            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            {
                return new Admin(
                		 resultSet.getInt("admin_id"),
                		 resultSet.getString("username"),
                        resultSet.getString("password"));
            }
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
		 return null;
	}
	
}
