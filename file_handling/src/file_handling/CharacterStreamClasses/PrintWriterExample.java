package file_handling.CharacterStreamClasses;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class PrintWriterExample {

	public static void main(String[] args) 
	{
		try {
           
            PrintWriter writer = new PrintWriter(new File("D://Programs//Monocept_Training//file_handling//src//file_handling//example.txt"));

          
            writer.println("Hello, from PrintWriter");
            writer.print("The answer is: ");
            writer.println(42);

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}

}
