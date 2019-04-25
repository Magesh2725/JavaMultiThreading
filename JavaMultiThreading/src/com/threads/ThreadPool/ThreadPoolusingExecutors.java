package com.threads.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class processor implements Runnable
{
private int id;
	processor(int id)
	{
		this.id=id;
	}
	@Override
	public void run() {
		System.out.println("Starting....."+id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished"+id);
		
	}
	
}

public class ThreadPoolusingExecutors {

	public static void main(String[] args) {
		
		ExecutorService threadpool=Executors.newFixedThreadPool(5);
		long start=System.currentTimeMillis();
		
	
		
		for(int i=0;i<5;i++) {
			threadpool.submit(new processor(i));
		}
		threadpool.shutdown();
		try {
			threadpool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end=System.currentTimeMillis();
		System.out.println("Total execution time in ms:"+(end-start));

	}

}
