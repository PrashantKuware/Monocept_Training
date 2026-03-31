package com.testing;

class myThread3 extends Thread
{
	public void run()
	{
		System.out.println("Thread name : "+Thread.currentThread().getName()+", Priority of the thread is : "+ Thread.currentThread().getPriority());
	}
}

public class threadPriority 
{

	public static void main(String[] args) 
	{
		myThread3 low = new myThread3();
		myThread3 high = new myThread3();

		low.setName("low_Priority_Thread");
		high.setName("high_priority_Thread");
		
		low.setPriority(1);
		high.setPriority(6);
		
		low.start();
		high.start();
	}

}
