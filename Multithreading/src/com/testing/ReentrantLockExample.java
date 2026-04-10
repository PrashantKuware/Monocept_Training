package com.testing;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockExample 
{
	public static void main(String[] args)
	{
		reentrantLock re = new reentrantLock();
		re.outerMethod();
	}
}

 class reentrantLock
{
	 private final Lock lock = new ReentrantLock();
	 
	 public void outerMethod()
	 {
		 lock.lock();
		 try
		 {
			 System.out.println("Outer method");
			 innerMethod();
		 }
		 finally
		 {
			 lock.unlock();
		 }
	 }
	 
	 public void innerMethod()
	 {
		 lock.lock();
		 try
		 {
			 System.out.println("inner method");
		 }
		 finally
		 {
			 lock.unlock();
		 }
	 }
}