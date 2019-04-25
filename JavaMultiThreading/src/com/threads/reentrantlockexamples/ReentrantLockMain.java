package com.threads.reentrantlockexamples;

public class ReentrantLockMain {

	public static void main(String[] args) throws InterruptedException {
		Account account=new Account();
		
		Thread person1=new Thread(() -> {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(account.withdraw(5))
				{
					System.out.println(String.format("Amount successfuly withdrawn by person:%s", Thread.currentThread().getName()));

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread person2=new Thread(() -> {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(account.withdraw(5))
				{
					System.out.println(String.format("Amount successfuly withdrawn by person:%s", Thread.currentThread().getName()));

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		person1.setName("Person1");
		person2.setName("Person2");
		
		person1.start();
		person2.start();
		
		person1.join();
		person2.join();
		
		System.out.println("balance amount:"+account.getAmount());
		

	}

}
