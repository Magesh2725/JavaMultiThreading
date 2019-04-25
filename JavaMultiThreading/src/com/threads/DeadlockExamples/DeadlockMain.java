package com.threads.DeadlockExamples;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockMain {
	Lock lock1=new ReentrantLock();
	Lock lock2=new ReentrantLock();
	public static void main(String[] args) {
		DeadlockMain dm=new DeadlockMain();
	
		Thread t1=new Thread(()-> {dm.methodForThread1();}) ;
		Thread t2=new Thread(()-> {dm.methodForThread2();}) ;
		
		t1.setName("Thread1");
		t2.setName("Thread2");
		
		t1.start();
		t2.start();
		
		try {
			
			t1.join();
			t2.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed");
	}
	
	public void methodForThread1()
	
	{
		lock1.lock();
		System.out.println(Thread.currentThread().getName()+" acquired LOck1"+" in MethodforThread1");
		lock2.lock();
		System.out.println(Thread.currentThread().getName()+" acquired LOck2"+" in MethodforThread1");
		
	}
	public void methodForThread2()
	{
		lock2.lock();
		System.out.println(Thread.currentThread().getName()+" acquired LOck2"+" in MethodforThread2");
		lock1.lock();
		System.out.println(Thread.currentThread().getName()+" acquired LOck1"+" in MethodforThread2");
		
		
	}
	

}
