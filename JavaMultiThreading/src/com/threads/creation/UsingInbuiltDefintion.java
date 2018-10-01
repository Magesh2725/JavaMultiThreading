package com.threads.creation;

public class UsingInbuiltDefintion {
	
	public static void main(String[] args) {
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++)
				{
						System.out.println("hello "+i+" time:"+System.currentTimeMillis());
				}
			}
		};

		
		Thread t=new Thread(runnable);
		Thread t1=new Thread(runnable);
		Thread t2=new Thread(runnable);
		t.start();
		t1.start();
		t2.start();
	}

}
