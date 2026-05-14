package com.studentcourse.model;

public class Admin 
{
	private int admin_id;
    private String username;
    private String password;

    public Admin(int admin_id,
    		String username,
    		String password)
    {
        this.admin_id = admin_id;
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }

    public int getAdminId()
    {
        return admin_id;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
}
