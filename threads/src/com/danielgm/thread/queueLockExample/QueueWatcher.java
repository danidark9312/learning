package com.danielgm.thread.queueLockExample;

import java.util.LinkedList;
import java.util.Queue;

public class QueueWatcher implements ThreadStorage{
	
	private Queue<String> messages;
	private int maxCapacity;
	
	
	public QueueWatcher(int maxQueueSize,long readInterval) {
		this.messages = new LinkedList<>();
		this.maxCapacity = maxQueueSize;
		new Thread(new ReaderThread(this,readInterval), "Reader").start();;
	}
	
	@Override
	synchronized public void addMessage(String message) {
			if(messages.size() >= maxCapacity){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				addMessageToQueue(message);
	}

	@Override
	synchronized public void readQueue() {
		if(messages.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String message = null;
		while((message = messages.poll())!=null){
			System.out.println(message);
		}
		notify();
	}
	
	private void addMessageToQueue(String message){
		messages.add(message);
		notify();
	}

}

	class ReaderThread implements Runnable{
		QueueWatcher queueWatcher;
		long readInterval;
		ReaderThread(QueueWatcher queueWatcher,long readInterval){
			this.queueWatcher = queueWatcher;
			this.readInterval = readInterval;
			
		}
		
		@Override
		public void run() {
			while(true){
				queueWatcher.readQueue();
				try {
					Thread.sleep(readInterval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
