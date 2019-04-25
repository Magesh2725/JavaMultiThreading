package synchronizersinbuilt;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
	private Semaphore semaphore;
	private List list;

	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println("removing number:"+list.get(list.size()-1));
			list.remove(list.size()-1);
			//semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	
	public Consumer(Semaphore semaphore,List list) {
		this.semaphore=semaphore;
		this.list=list;
		// TODO Auto-generated constructor stub
	}


}
