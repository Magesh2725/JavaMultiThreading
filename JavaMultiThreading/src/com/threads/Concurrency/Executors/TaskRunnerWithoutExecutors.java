package com.threads.Concurrency.Executors;

public class TaskRunnerWithoutExecutors {

	public static void main(String[] args) {
		Task task=new Task(1, 1);
		long start=System.currentTimeMillis();
		Thread t1=new Thread(task);
		Thread t2=new Thread(task);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
System.out.println(task.getCounter());
long end=System.currentTimeMillis();
System.out.println("Time taken "+(end-start));
	}

}
