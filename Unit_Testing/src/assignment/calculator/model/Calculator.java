package assignment.calculator.model;

public class Calculator 
{
	public double add(int num1, int num2)
	{
		return num1+num2;
	}
	public double subtract (int num1, int num2)
	{
		return num1-num2;
	}
	public double multiply  (int num1, int num2)
	{
		return num1*num2;
	}
	public double divide(int num1, int num2)
	{
		if(num2 == 0 || num1 ==0)
		{
			throw new IllegalArgumentException("Invalid number");
		}
		return num1/num2;
	}
}
