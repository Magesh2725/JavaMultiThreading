package synchronizersinbuilt;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchWorker implements Runnable {
	
	private String name;
	private CountDownLatch countDownLatch;
	private int delay;
	
	
	public CountdownLatchWorker(String name, CountDownLatch countDownLatch, int delay) {
		super();
		this.name = name;
		this.countDownLatch = countDownLatch;
		this.delay = delay;
	}


	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+" : "+"Started working");
			Thread.sleep(delay);
			System.out.println(Thread.currentThread().getName()+" : "+"Completed working");
			countDownLatch.countDown();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
