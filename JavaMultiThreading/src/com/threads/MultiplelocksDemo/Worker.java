package com.threads.MultiplelocksDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	private Random random=new Random();
	private List <Integer> list1=new ArrayList();
	private List <Integer> list2=new ArrayList();
	Object lock1=new Object();
	Object lock2=new Object();
	
	public   void stageone()
	{
		synchronized(lock1)
		{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list1.add(random.nextInt(100));
		}
	}
	public  void stagetwo()
	{
		synchronized(lock2)
		{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list2.add(random.nextInt(100));
		}
	}
	
	public void process()
	{
		for(int i=0;i<1000;i++)
		{
			stageone();
			stagetwo();
		}
	}
	
	public void main()
	{
		System.out.println("starting...");
		long start=System.currentTimeMillis();
		
	Thread t1=	new Thread(new Runnable() {

			@Override
			public void run() {
				process();
				
			}});
	Thread t2=	new Thread(new Runnable() {

			@Override
			public void run() {
				process();
				
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
		
		long end=System.currentTimeMillis();
		
		System.out.println(end-start+ " ms");
		
		System.out.println("size of list1:"+list1.size()+"size of list2:"+list2.size());
	}

}
