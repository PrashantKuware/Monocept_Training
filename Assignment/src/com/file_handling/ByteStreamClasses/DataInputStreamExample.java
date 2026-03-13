package file_handling.ByteStreamClasses;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamExample 
{
	public static void main(String[] args) throws Exception {

        DataInputStream dis =
                new DataInputStream(new FileInputStream("D://Programs//Monocept_Training//file_handling//src//file_handling//example.txt"));

        int number = dis.readInt();

        System.out.println(number);

        dis.close();
    }
}
