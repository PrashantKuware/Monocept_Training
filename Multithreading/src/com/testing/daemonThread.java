package com.testing;

class daemonTest extends Thread
{
	public void run()
	{
		System.out.println( Thread.currentThread().isDaemon());
		System.out.println("this is ");
	}
}

public class daemonThread 
{
	public static void main(String[] args) throws InterruptedException
	{
		daemonTest t = new daemonTest();
		t.setDaemon(true);
		t.start();
//		Thread.sleep(2000);
	}
}
