package com.testing;

class daemonTest extends Thread {
	public void run() 
	{
	try {
			if(Thread.currentThread().isDaemon())
			{
				Thread.sleep(2000);
			}
		
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		finally
		{
			System.out.println(Thread.currentThread().isDaemon());
			System.out.println("this is Daemon");
		}
	}
}

public class daemonThread {
    public static void main(String[] args) throws InterruptedException {
        daemonTest t = new daemonTest();
        t.setDaemon(true);
        t.start();

        Thread.sleep(3000); // wait for daemon thread
        System.out.println("main thread running ...");
    }
}
