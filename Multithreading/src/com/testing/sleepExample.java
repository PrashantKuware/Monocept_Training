package com.testing;

public class sleepExample extends Thread
{

	public void run() 
	{
		try
		{
			for(int i=0;i<5;i++)
			{
				System.out.println(i+ " : "+Thread.currentThread().getName()+", Priority : "+Thread.currentThread().getPriority());
				sleep(1000);				
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) 
	{
		sleepExample s1 = new sleepExample();
		sleepExample s2 = new sleepExample();
		
//		s1.run();
		s2.start();
//		s2.interrupt();
		
	}

}
