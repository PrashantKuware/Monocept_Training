package com.java.student_data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssociatedQueries 
{
	private Connection connection;

    public AssociatedQueries(Connection connection) 
    {
        this.connection = connection;
    }
	
	// 1. Print Student Table
    
    public void getAllStudent()
    {
    	try {
			
			PreparedStatement statement = connection.prepareStatement("select*from student");
			
			ResultSet result = statement.executeQuery();
			
			while(result.next())
			{
				System.out.println(result.getInt("studentid") + " | " + result.getString("name")+" | "+ result.getInt("age")+ " | "+result.getInt("percentage"));
			}
					
		} catch (SQLException e) {
			
			e.getMessage();
		}
    }
    
    // 2. Insert a new student record into the student table.
    
    public void inserNewStudent()
    {
    	String sqlQuery2 = "insert into student values (?,?,?,?,?)";
    	try 
    	{
			PreparedStatement statement2 = connection.prepareStatement(sqlQuery2);
			
			statement2.setInt(1, 19);
			statement2.setInt(2, 119);
			statement2.setString(3, "Ravi kumar");
			statement2.setInt(4, 34);
			statement2.setInt(5, 50);
			
			statement2.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.getMessage();
		}
    }
    
    // 3. Insert 5 student records using batch processing.
    
    public void insertStudentUsingBatchProcessing()
    {
    	String sqlQuery3 = "insert into student VALUES (?, ?, ?, ?, ?)";
    	
    	try(PreparedStatement statement3 = connection.prepareStatement(sqlQuery3))
    	{
    		//First Student
    		statement3.setInt(1, 20);
    		statement3.setInt(2, 120);
    		statement3.setString(3, "Nikita");
    		statement3.setInt(4, 32);
    		statement3.setDouble(5, 78.32);
    		statement3.addBatch();
    		
    		//Second Student
    		statement3.setInt(1, 21);
    		statement3.setInt(2, 121);
    		statement3.setString(3, "Reotsu");
    		statement3.setInt(4, 13);
    		statement3.setDouble(5, 87.90);
    		statement3.addBatch();
    		
    		//Third Student
    		statement3.setInt(1, 22);
    		statement3.setInt(2, 122);
    		statement3.setString(3, "Johny Bravo");
    		statement3.setInt(4, 22);
    		statement3.setDouble(5, 54.32);
    		statement3.addBatch();
    		
    		//Fourth Student
    		statement3.setInt(1, 23);
    		statement3.setInt(2, 124);
    		statement3.setString(3, "Paulo Alto");
    		statement3.setInt(4, 45);
    		statement3.setDouble(5, 92.36);
    		statement3.addBatch();
    		
    		 int[] result = statement3.executeBatch();
    		 
    		 for (int i = 0; i < result.length; i++) {
    	            System.out.println("Query " + (i + 1) + " inserted: " + result[i]);
    	        }
    	}
    	catch(SQLException e)
    	{
    		System.out.println( e.getMessage());
    	}
    }
	
    // 4. Fetch and display a student record based on a given id.
     public void getStudentUsingGivenID(int id)
     {
    	 String sqlQuery4 = "select * from student where studentid = ?";
    	 
    	 try {
			PreparedStatement statement4 = connection.prepareStatement(sqlQuery4);
			statement4.setInt(1, id);
			ResultSet result4 = statement4.executeQuery();
			
			while(result4.next())
			{
				System.out.println(result4.getInt("studentid") + " | " + result4.getString("name")+" | "+ result4.getInt("age")+ " | "+result4.getInt("percentage"));
			}
			
		} catch (SQLException e) {
			
			e.getMessage();
		}
     }
     
     // 5. Display all students belonging to a specific branch.
     
     public void getStudentWithSpecificAge(int age)
     {
    	 String sqlQuery5 = "select name from student where age = ?";
    	 
    	 try(PreparedStatement statement5 = connection.prepareStatement(sqlQuery5)) 
    	 {
			
			statement5.setInt(1, age);
			try(ResultSet result5 = statement5.executeQuery())
			{
				while(result5.next())
				{
					System.out.println(result5.getString("name"));
				}
			}
			
			
    		 
		} catch (SQLException e) {
			e.getMessage();
		}
     }
     
     //6. Display all students whose marks are greater than a given value.
     
     public void getStudentWithGreaterMarks(int marks)
     {
    	 String sqlQuery6 = "select name from student where percentage > ?";
    	 
    	 try(PreparedStatement statement6 = connection.prepareStatement(sqlQuery6))
    	 {
    		 statement6.setInt(1, marks);
    		 try(ResultSet result6 = statement6.executeQuery())
    		 {
    			 while(result6.next())
 				{
 					System.out.println(result6.getString("name"));
 				}
    		 }
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
     }
     
     //7. Display students whose age lies between two given values.
     
     public void getStudentBetweenGivenAge(int age1, int age2)
     {
    	 String sqlQuery7 = "select name from student where age between ? and ?";
    	 
    	 try(PreparedStatement statement7 = connection.prepareStatement(sqlQuery7))
    	 {
    		 statement7.setInt(1, age1);
    		 statement7.setInt(2, age2);
    		 
    		 try(ResultSet result7 = statement7.executeQuery())
    		 {
    			 while(result7.next())
    			 {
    				 System.out.println(result7.getString("name"));
    			 }
    		 }
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
     }
     
     //8. Update the name of a student using their id.
     
     public void studentUpdateUsingId(int id, String name)
     {
    	 String sqlQuery8 = "update student set name = ? where studentid = ?";
    	 
    	 try(PreparedStatement statement8 = connection.prepareStatement(sqlQuery8))
    	 {
    		 statement8.setString(1, name);
    		 statement8.setInt(2, id);
    		 
    		 statement8.executeUpdate();
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
     }
     
     //9. Increase the marks of all students belonging to a specific age by a given value.
     
     public void increaseMarksByGivenAge( int age, double percent)
     {
    	 String sqlQuery9 = "update student set percentage = (percentage+?) where age = ?";
    	 
    	 try(PreparedStatement statement9 = connection.prepareStatement(sqlQuery9))
    	 {
    		 statement9.setDouble(1, percent);
    		statement9.setInt(2, age); 
    		statement9.executeUpdate();
    	 }
    	 catch(SQLException e)
    	 {
    		 e.getMessage();
    	 }
     }
     
     //10. Delete a student record using their id.
     
     public void deleteStudentRecord(int id)
     {
    	 String sqlQuery10 = "delete from student where studentid=?";
    	 
    	 try(PreparedStatement statement10 = connection.prepareStatement(sqlQuery10))
    	 {
    		 statement10.setInt(1, id);
    		 statement10.executeUpdate();
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
     }
}
