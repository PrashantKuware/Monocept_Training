package com.file_handling.CharacterStreamClasses;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {

	public static void main(String[] args) 
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("D://Programs//Monocept_Training//file_handling//src//file_handling//example.txt", true))) 
		{
//			To append to a file instead of overwriting it, pass true to the FileWriter constructor: new FileWriter("filename.txt", true)
            bw.write("First line of text.");
            bw.newLine(); 
            bw.write("Second line of text.");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) 
		{
            System.out.println("Error writing to the file: " + e.getMessage());
        }
	}

}
