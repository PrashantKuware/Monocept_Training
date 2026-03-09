package file_handling.CharacterStreamClasses;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {

	public static void main(String[] args) 
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("D://Programs//Monocept_Training//file_handling//src//file_handling//example.txt"));
					String line;
			while((line = br.readLine()) != null)
			{
				 System.out.println(line);
			}
		}
		catch(IOException  e)
		{
			e.printStackTrace();
		}
		
	}

}

// It has default 8KB buffer