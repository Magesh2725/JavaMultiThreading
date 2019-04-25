package synchronizersinbuilt;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CoundownLatchDemo {
//This example waits for all the worker threads to do some work and after that main thread collects the process
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		CountDownLatch countDownLatch=new CountDownLatch(5);
		executorService.submit(new CountdownLatchWorker("First worker", countDownLatch, 1000));
		executorService.submit(new CountdownLatchWorker("Second worker", countDownLatch, 1000));
		executorService.submit(new CountdownLatchWorker("Third worker", countDownLatch, 1000));
		executorService.submit(new CountdownLatchWorker("Fourth worker", countDownLatch, 1000));
		executorService.submit(new CountdownLatchWorker("Fifth worker", countDownLatch, 1000));
		//two methods await() which blocks until countdown latch becomes 0 but below method waits for specific period of time
		countDownLatch.await(1,TimeUnit.SECONDS);
		System.out.println(Thread.currentThread().getName()+" has finished");
		executorService.shutdown();
		
		
		
	}

}
