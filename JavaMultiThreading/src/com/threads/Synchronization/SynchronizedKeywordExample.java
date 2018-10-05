package com.threads.Synchronization;

public class SynchronizedKeywordExample {
	
	public int count=0;
	
	public  synchronized void increase()
	{
		count++;
	}
	
	public void doWork()
	{
		
		Thread t1=new Thread(new Runnable()
				{

					@Override
					public void run() {
						for(int i=0;i<10000;i++)
						{
							increase();
						}
						
					}
			
				});
		
		Thread t2=new Thread(new Runnable()
				{

					@Override
					public void run() {
						for(int i=0;i<10000;i++) {
							increase();
						}
						
					}});
		
				
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(count);
	}

	public static void main(String[] args) {
		
		SynchronizedKeywordExample example=new SynchronizedKeywordExample();
		example.doWork();
		
	}

}
