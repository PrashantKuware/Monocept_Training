package file_handling.CharacterStreamClasses;
import java.io.FileReader;
import java.io.IOException;

 class FileReaderExample 
{

	public static void main(String[] args) 
	{
		try
		{
			FileReader reader = new FileReader("D://Programs//Monocept_Training//file_handling//src//file_handling//example.txt");
			int ch;
			while((ch = reader.read()) != -1)
			{
				System.out.print((char) ch);
			}
		}
		catch(IOException e)
		{
		
			System.out.print(e);
		}
		
	}

}
