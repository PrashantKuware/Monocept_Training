package file_handling.ByteStreamClasses;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamExample 
{
	 public static void main(String[] args) throws Exception {

	        DataOutputStream dos =
	                new DataOutputStream(new FileOutputStream("D://Programs//Monocept_Training//file_handling//src//file_handling//example.txt", true));

	        dos.writeInt(100);
	        dos.writeDouble(10.5);

	        dos.close();
	    }
}
