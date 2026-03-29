package com.exceptionHandling.testing;

import java.util.Scanner;

public class multipleCatchBlock 
{

	public static void main(String[] args) 
	{
//		String[] array = null;
		String[] array = {"first","second"};
		
		try
		{
			System.out.println(array[5]);
		}
		catch(ArrayIndexOutOfBoundsException aiob)
		{
			System.out.println("Exception using getMessage :" + aiob.getMessage());
			System.out.println("Exception using toString :" + aiob.toString());
			System.out.println("Exception using printStackTrace");
			aiob.printStackTrace();
		}
		catch(NullPointerException npe)
		{
			System.out.println("Exception using getMessage :" + npe.getMessage());
			System.out.println("Exception using toString :" + npe.toString());
			System.out.println("Exception using printStackTrace");
			npe.printStackTrace();
		}
	}

}
