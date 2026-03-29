package com.file_handling.ByteStreamClasses;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {

	public static void main(String[] args) 
	{
		try (FileInputStream fis = new FileInputStream("D://Downloads//Browser//image.jpg")) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
