package com.testing;

class moviesBookApp
{
	int total_seat = 10;
	synchronized public void bookSeat(int seat)
	{
		if(total_seat > seat)
		{
			total_seat = total_seat-seat;
			System.out.println("ticket booked successfully ");
			System.out.println("current available seats : "+total_seat);
		}
		else
		{
			System.out.println("seat can not be booked ");
			System.out.println("you can book only : "+total_seat);
		}
	}
}

public class synchronizationExample extends Thread
{
	static moviesBookApp b;
	int seat;
	public void run()
	{
		b.bookSeat(seat);
	}

	public static void main(String[] args) throws InterruptedException
	{
		b = new moviesBookApp();
		synchronizationExample t1 = new synchronizationExample();
		t1.seat=40;
		t1.start();
		
//		sleep(10);
		
		synchronizationExample t2 = new synchronizationExample();
		t2.seat=5;
		t2.start();
		
	}

}
