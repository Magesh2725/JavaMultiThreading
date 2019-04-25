package com.threads.Concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConcurrentCollectionBlockingQueue {
	
	static BlockingQueue<String> container=new ArrayBlockingQueue<>(2);

	public static void main(String[] args) throws InterruptedException {
		
		Producer producer=new Producer(container);
		List<String> l=Arrays.asList("one","two","three","four","five","Six");
		producer.setList(l);
		Consumer consumer=new Consumer(container);
		consumer.n=l.size();
		Thread t1=new Thread(producer);
		Thread t2=new Thread(consumer);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("COmepleted");

	}

}
