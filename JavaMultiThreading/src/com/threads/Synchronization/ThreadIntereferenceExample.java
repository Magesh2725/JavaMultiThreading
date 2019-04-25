package com.threads.Synchronization;

class Counter
{
	private int count=10;
	
	public void increment()
	{
		count++;
	}
	public void decrement()
	{
		count--;
	}
	public int getVal()
	{
		return count;
	}
}

public class ThreadIntereferenceExample {
	
		public static void main(String[] args) throws InterruptedException {
		Counter c=new Counter();
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1;i++)
				c.increment();
				
				
			}
		});
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1;i++)
				c.decrement();
				
				
			}
		});
		t2.start();
		t1.start();
		
		for(int i=0;i<10000;i++)
		{
			//System.out.println(i);
		}
			
		System.out.print(c.getVal());

	}
	
	
}
