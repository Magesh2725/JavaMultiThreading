package com.threads.Concurrency.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRunner {

	public static void main(String[] args) {
		
		ExecutorService exService=Executors.newFixedThreadPool(2);
		Task task=new Task(1,1);
		
		 
		
		exService.execute(task);
		exService.execute(task);
		
		exService.shutdown();
	    while (!exService.isTerminated()) { }   
	    System.out.println("count is:"+task.getCounter());
	    long end=System.currentTimeMillis();
	   // System.out.println("Total time"+(end-start));
	}

}
