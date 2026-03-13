package file_handling.ByteStreamClasses;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {

	public static void main(String[] args) 
	{
		 String data = "Hello World from FileOutputStream";
	        try (FileOutputStream fos = new FileOutputStream("D://Programs//Monocept_Training//file_handling//src//file_handling//example.txt")) 
	        {
	            fos.write(data.getBytes()); 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
