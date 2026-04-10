package com.testing;
import java.util.*;

class myThread extends Thread
{	
	@Override
	public void run()
	{
//		try {
//			
//			sleep(2000);
//		} catch (InterruptedException e) 
//		{
//			e.printStackTrace();
//		}
		System.out.println("The task is Executing...");
		System.out.println(Thread.currentThread().getName());
	}
}

class myThread1 extends Thread
{	
	@Override
	public void run()
	{
		Thread.currentThread().setName("ABCD");
		System.out.println("The task is Executing from myThread1...");
		
		System.out.println(Thread.currentThread().getName());
		
	}
}

public class createThread 
{
	public static void main(String[] args)
	{
		myThread t1 = new myThread();
		myThread1 t2 = new myThread1();
//		t.start();
		
		t1.run();
		
//		t1.start();
		t2.start();
		
		System.out.println("main Thread Executing...");
	}
}



