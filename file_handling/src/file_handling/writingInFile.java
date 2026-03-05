package file_handling;
import java.io.FileWriter;
import java.io.IOException;
public class writingInFile {

	public static void main(String[] args) throws IOException{
		FileWriter writer = new FileWriter("sample.txt");
		writer.write("Hello java File Handling");
		writer.close();
		System.out.println("Data Written Successfully");
	}

}
