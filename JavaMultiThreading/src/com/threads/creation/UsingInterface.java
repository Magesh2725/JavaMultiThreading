package com.threads.creation;


class Runner implements Runnable
{

	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
				System.out.println("hello "+i+" time:"+System.currentTimeMillis());
		}
		
	}
	
}

public class UsingInterface {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runner());
		Thread t2=new Thread(new Runner());
		Thread t3=new Thread(new Runner());
		t1.start();
		t2.start();
		t3.start();
		
		

	}

}
