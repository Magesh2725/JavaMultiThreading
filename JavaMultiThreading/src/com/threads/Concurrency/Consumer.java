package com.threads.Concurrency;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	
	BlockingQueue<String> bq;
	int n;
	

	public Consumer(BlockingQueue bq) {
		this.bq=bq;
	}

	@Override
	public void run() {
		try {
			for(int i=0;i<n;i++)
			System.out.println("taking element from queue"+bq.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
