package com.Testing.pack2;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.Testing.pack1.test1;

class InvalidSAgeException extends Exception
{
	InvalidSAgeException(String msg)
	{
		super(msg);
	}
}

 class test2 
{
	
	public static void checkAge(int age) throws InvalidSAgeException
	{
		if(age <0 || age > 18)
		{
			 throw new InvalidSAgeException("Invalid age");
		}
		else
		{
			System.out.println("valid");
		}
	}
	 
    public static void main(String[] args) 
    {
    	int age;
    	try(Scanner sc = new Scanner(System.in))
    	{
    		System.out.println("Enter age");
    		age = sc.nextInt();
    		checkAge(age);
    		
    	}
    	catch(InvalidSAgeException e)
    	{
    		System.out.println(e);
    	}
    	finally
    	{
    		System.out.println("finally");
    	}
    }
}