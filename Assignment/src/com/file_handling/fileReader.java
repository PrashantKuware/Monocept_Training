package file_handling;
import java.io.FileReader;
import java.io.IOException;

public class fileReader {

	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReader("sample.txt");
		int ch;
		while((ch=reader.read()) != -1)
		{
			System.out.print((char)ch);
		}
		reader.close();
	}

}
