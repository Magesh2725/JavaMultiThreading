package synchronizersinbuilt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
	static List<Integer> l=new ArrayList();
	static Semaphore semaphore=new Semaphore(5);

	public static void main(String[] args) throws InterruptedException {
		
		
		
		Producer producer=new Producer(semaphore, l);
		Consumer consumer=new Consumer(semaphore, l);
		
		ExecutorService executorService=Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++)
		{
		executorService.submit(producer);
		executorService.submit(consumer);
		}
		
		executorService.awaitTermination(1, TimeUnit.SECONDS);
		
		executorService.shutdown();
		
System.out.println(l.size());
		
	}

}
