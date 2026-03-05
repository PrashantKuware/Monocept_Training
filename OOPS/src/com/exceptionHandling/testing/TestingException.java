package com.exceptionHandling.testing;
import java.io.FileInputStream;
import java.io.IOException;

public class TestingException 
{
	void readFile() throws IOException
	{
		try()
		{
			int data = file.read();
			System.out.println("First byte of the file: " + data);
		}
	}
	
public static void main(String[] args)
{
	try (FileInputStream fis = new FileInputStream("test.txt"))
	{
		TestingException obj = new TestingException();
		obj.readFile();
	}
	catch (IOException e)
	{
		System.out.println("Exception handled: " + e);
	}
}
}
