package com.threads.creation;

class Runner2 extends Thread
{
@Override
	public void run()
	{
	for(int i=0;i<10;i++)
	{
			System.out.println("hello "+i+" time:"+System.currentTimeMillis());
	}	
	}
}

public class UsingInheritance {

	public static void main(String[] args) {
		Runner2 runner=new Runner2();
		Runner2 runner1=new Runner2();
		Runner2 runner2=new Runner2();
		
		runner.start();
		runner1.start();
		runner2.start();

	}

}
