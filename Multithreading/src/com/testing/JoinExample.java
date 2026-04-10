package com.testing;

public class JoinExample extends Thread
{
	static Thread mainThread;

	public void run()
	{
		
		try
		{ 
			
			for(int i=0;i<5;i++)
			{
				System.out.println("child thread : " +i);
				sleep(1000);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		 mainThread = Thread.currentThread();
		JoinExample j = new JoinExample();
		
		j.start();
		j.join();
		
		try
		{
			for(int i=0;i<5;i++)
			{
				System.out.println("parent thread : " +i);
				sleep(1000);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		

	}

}
