package com.danielgm.concurrencyTools;

import java.util.ArrayList;

public class ThreadReturn {
	
	public static void main(String[] args) {
		ThreadWithReturn threadWithReturn = new ThreadWithReturn("returnThread");
		threadWithReturn.start();
		
		
		System.out.println(threadWithReturn.getResult());
		System.out.println("finished");
	}
	

	
}

class ThreadWithReturn extends Thread{
	
	private Object lock = new Object();
	private Object result = null;
	private int state = 0; //not started
	
	public ThreadWithReturn(String name) {
		super(name);
		result = new Object();
	}
	
	@Override
	public synchronized void start() {
		synchronized (lock){
			super.start();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public synchronized void run() {
		synchronized (lock){
			this.state = 1; //running
			System.out.println(Thread.currentThread().getName());
			result = new ArrayList<String>();
			for (int i = 0; i < 100; i++) {
				((ArrayList<String>) result).add("entered "+i);
				try {
					sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
		
	}
	
	public Object getResult(){
		//wait until the thread start before returning
		while(this.state == 0){
			System.out.println("not started yet");
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("started");
		
		synchronized (lock) {
			return result;
		}
		
	}
	
	
}
