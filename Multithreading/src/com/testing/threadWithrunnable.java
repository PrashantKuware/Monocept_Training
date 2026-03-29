package com.testing;

public class threadWithrunnable implements Runnable
{
	@Override
	public void run()
	{
//		try {
//			
//			 Thread.sleep(2000);
//		} catch (InterruptedException e) 
//		{
//			e.printStackTrace();
//		}
		System.out.println("The task is Executing...");
		System.out.println(Thread.currentThread().getName());
	}
	
	

	public static void main(String[] args) 
	{
		threadWithrunnable t = new threadWithrunnable();
		Thread th = new Thread(t,"newThreadName");
		th.start();
//		Thread.currentThread().setName("Prashant");
		System.out.println("main Thread Executing...");
//		System.out.println(Thread.currentThread().getName());
//		System.out.println(10/0);

	}

}
