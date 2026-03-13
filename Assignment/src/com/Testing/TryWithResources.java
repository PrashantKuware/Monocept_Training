package com.Testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MyResource implements AutoCloseable {

    void display() {
        System.out.println("Using resource");
    }

    public void close() {
        System.out.println("Resource closed");
    }
}


public class TryWithResources 
{
	public static void main(String[] args) {

//        try(FileReader fr = new FileReader("D://Programs//Monocept_Training//Assignment//src//com//file_handling//example.txt");
//        		BufferedReader br = new BufferedReader(fr))
//        {
//           System.out.println(br.readLine());
//        }
//        catch(IOException e)
//        {
//        	System.out.println(e);
//        }
		
		
		 try(MyResource r = new MyResource()) {
	            r.display();
	        }	
    }
}
