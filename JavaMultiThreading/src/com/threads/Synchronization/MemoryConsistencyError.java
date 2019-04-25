package com.threads.Synchronization;
class Counterclass
{
	private  int  count;
	
	public void increment()
	{
		count++;
	}
	public int getCount()
	{
		return count;
	}
}

public class MemoryConsistencyError {
	
	

	public static void main(String[] args) throws InterruptedException {
		Counterclass c=new Counterclass();
		Thread t1=new Thread(() -> c.increment());
		Thread t2=new Thread(() -> System.out.println(c.getCount()));
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

}
