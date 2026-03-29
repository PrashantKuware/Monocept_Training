package com.file_handling.ByteStreamClasses;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamExample 
{
	public static void main(String[] args) throws Exception {

        BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream("D://Programs//Monocept_Training//file_handling//src//file_handling//example.txt"));

        String text = "Buffered Output Example";

        bos.write(text.getBytes());

        bos.close();
    }
}
