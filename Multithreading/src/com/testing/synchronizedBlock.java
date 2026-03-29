package com.testing;

class moviesBookApp1
{
	int total_seat=10;
	
	 public void bookSeat(int seat)
	{
		 synchronized(this)
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
}

public class synchronizedBlock extends Thread
{
	static moviesBookApp1 b;
	int seat;
	public void run()
	{
		b.bookSeat(seat);
	}

	public static void main(String[] args) throws InterruptedException
	{
		b = new moviesBookApp1();
		synchronizedBlock t1 = new synchronizedBlock();
		t1.seat=40;
		t1.start();
		
//		sleep(10);
		
		synchronizedBlock t2 = new synchronizedBlock();
		t2.seat=5;
		t2.start();
		
	}

}
