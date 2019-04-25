package com.threads.reentrantlockexamples;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	
	private int amount=10;
	
	public Lock lock=new ReentrantLock();
	
	public  boolean  withdraw(int amount) throws InterruptedException
	{
		//lock.lock();
		boolean flag=lock.tryLock(2000, TimeUnit.MILLISECONDS);//lock.tryLock();
		try
		{
		if(flag)
		{
			System.out.println("lock aquired by "+Thread.currentThread().getName());
			if(this.amount>=amount)
			{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.lock();
			this.amount=this.amount-amount;
			System.out.println("lock held count:"+((ReentrantLock) lock).getHoldCount());
			lock.unlock();
			return true;
			}
		
		
		}
		else
		{
			System.out.println("lock not acquired by Thread:"+Thread.currentThread().getName());
		}
		}
		finally
		{
			System.out.println("lock held count:"+((ReentrantLock) lock).getHoldCount());
			
			if(((ReentrantLock) lock).isHeldByCurrentThread())
			lock.unlock();
		}
		return false;
		
	}
	public void deposit()
	{
		
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
