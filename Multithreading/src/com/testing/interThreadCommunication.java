package com.testing;

 class totalEarning implements Runnable
{
	int total=0;
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			total = total+150;
			
		}
	}
}

public class interThreadCommunication 
{
	public static void main(String[] args)
	{
		totalEarning te = new totalEarning();
		Thread t = new Thread(te);
		
		t.start();
		try
		{
			Thread.sleep(10);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println(te.total);
	}
}
