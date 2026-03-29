package com.file_handling.ByteStreamClasses;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamExample 
{
	public static void main(String[] args) throws Exception {

        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream("D://Programs//Monocept_Training//Assignment//src//com//file_handling//example.txt"));

        int data;

        while((data = bis.read()) != -1) {
            System.out.print((char)data);
        }

        bis.close();
    }
}
