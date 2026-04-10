package com.testing;

 class totalEarning implements Runnable
{
	int total=0;
	public void run()
	{
		synchronized(this)
		{
			for(int i=0;i<10;i++)
			{
				total = total+5;
				
			}
			this.notify();
		}
		
	}
}

public class interThreadCommunication 
{
	public static void main(String[] args)
	{
		totalEarning te = new totalEarning();
		Thread t = new Thread(te);
		
		System.out.println(te.total);
		t.setPriority(10);
		t.start();
		
		synchronized(t)
		{
			try {
				t.wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		System.out.println(te.total);
	}
}
