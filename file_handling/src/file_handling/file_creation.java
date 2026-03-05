
package file_handling;
import java.io.File;
import java.io.IOException;
public class file_creation {

	public static void main(String[] args) throws IOException 
	{
		File file = new File("sample.txt");
		if(file.createNewFile())
		{
			System.out.println("File Created");
		}
		else {
            System.out.println("File Already Exists");
        }
		
		System.out.println(file.exists());
		System.out.println(file.getName());
		System.out.println(file.length());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
	}

}
