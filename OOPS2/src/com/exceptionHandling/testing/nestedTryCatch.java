package com.exceptionHandling.testing;

public class nestedTryCatch {

	public static void main(String[] args) 
	{
		String[] array = {"first","second"};
		int number1 = 5, number2 = 0, result;
		try
		{
			result = number1/number2;
			System.out.println("result : "+result);
			try
			{
				System.out.println("String element"+array[5]);
			}
			catch(ArrayIndexOutOfBoundsException  ae)
			{
				System.out.println(" ArrayIndexOutOfBoundsException: "+ae);
			}
		}
		catch(ArithmeticException e)
		{
			System.out.println(" ArithmeticException: "+e);
		}

	}

}
