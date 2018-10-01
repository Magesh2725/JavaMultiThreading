package com.threads.Synchronization;

import java.util.Scanner;

/**
 * 
 * @author MURUGESANSHANTHIM
 * This program will test the thread stop using the common variable
 * 
 * this cannot be guranteed because sometimes running state will be cached hence Volatile keyword should be used
 */

public class AccessingCommonVariable extends Thread{
	
	public volatile boolean  runningState=true;
	@Override
	 public void run()
	 {
		 
		
		while(runningState)
		{
			System.out.println("running");
		}
	 }
	
	public void shutdown()
	{
		runningState=false;
	}

	public static void main(String[] args) {
		System.out.println("Stops when press enter");
		AccessingCommonVariable acv=new AccessingCommonVariable();
		acv.start();
		Scanner sc =new Scanner(System.in);
		
		sc.nextLine();
		acv.shutdown();
		

	}

}
