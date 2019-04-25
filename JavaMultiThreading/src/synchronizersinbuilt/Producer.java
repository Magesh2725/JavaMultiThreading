package synchronizersinbuilt;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
	
	private Semaphore semaphore;
	private List list;
	private Random random=new Random();
	@Override
	public void run() {
		try {
			semaphore.acquire();
			int number=random.nextInt();
			list.add(number);
			System.out.println("number added:"+number);
			//semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Producer(Semaphore semaphore,List list) {
		this.semaphore=semaphore;
		this.list=list;
		// TODO Auto-generated constructor stub
	}

}
