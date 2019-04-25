package com.threads.Concurrenthashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HashMapExample {
	 
	 
	 
	public static void main(String[] args) throws InterruptedException {
		HashMapExample hexa=new HashMapExample();
	HashMap hashmap=new HashMap();
		hashmap.put("India",0L);
		hashmap.put("Pakistan",0L);
		hashmap.put("Chine",0L);
		hashmap.put("Bulgaria",0L);
		hashmap.put("Greece",0L);
		
		
		Thread t1=new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hexa.order(hashmap) ;});
		Thread t2=new Thread(() -> {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hexa.order(hashmap) ;});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
System.out.println(hashmap);

	}
	
	

	public void order(HashMap<String,Long> map)
	{
		for(int i=0;i<100;i++)
		{
			Iterator<String> country = map.keySet().iterator();
			
			while(country.hasNext())
			{
				String contry=country.next();
				Long value=map.get(contry);
				map.put(contry, value+1);
				
			}
			//System.out.println("Thread name"+Thread.currentThread().getName()+"->"+map.get("India"));
		}
	}

	public HashMapExample() {
		
		
	}

}
