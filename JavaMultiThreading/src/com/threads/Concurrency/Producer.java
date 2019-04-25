package com.threads.Concurrency;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	
	BlockingQueue< String> bq;
	List <String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Producer(BlockingQueue bq) {
		this.bq=bq;
	}

	@Override
	public void run() {
		
			for(String val:list)
			{
			bq.add(val);
			System.out.println("inserted value:"+val);
			}
	}

}
