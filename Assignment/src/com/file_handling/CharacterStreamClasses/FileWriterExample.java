package file_handling.CharacterStreamClasses;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

	public static void main(String[] args) 
	{
		 String data = " This is a line of text from FileWriterExample";
		 
		 try
		 {
			 FileWriter writer = new FileWriter("D://Programs//Monocept_Training//file_handling//src//file_handling//example.txt");
			 writer.write(data);
			 writer.close();  
			 System.out.println("Successfully wrote to the file.");
		 }
		 catch(IOException  e)
		 {
			 System.out.println("An error occurred: " + e.getMessage());
		 }

	}

}
