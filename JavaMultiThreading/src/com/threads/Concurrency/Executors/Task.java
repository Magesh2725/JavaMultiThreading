package com.threads.Concurrency.Executors;

public class Task implements Runnable {
	
	private int counter;
	private int task;
	
	

	public Task(int counter,int task) {
		super();
		this.counter = counter;
		this.task=task;
	}


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}
	public  int  incrementCtr()
	{
		return counter++;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<10000;i++)
		incrementCtr();
		//System.out.println("Task: "+task+" counter vAL:"+counter);
	}

}
