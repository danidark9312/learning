package com.danielgm.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ThreadSample {
	static List list;
	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String read;
		while((read=bi.readLine())!= null){
			if(read.equals("1"))
				addElementsToList();
			if(read.equals("2"))
				removeLastElementsInList();
			if(read.equals("3")) {
				synchronized (list) {
					//wake one threads with list monitor
					list.notify();
				}
			}
			if(read.equals("4"))
				synchronized (list) {
					//wake all threads with list monitor
					list.notifyAll();
				}
		}
	}
	

	private static void removeLastElementsInList() {
		if(list==null)
			list = new ArrayList<>();
		new Thread(new TaskExecutor(list, Operation.REMOVELAST)).start();
		
	}


	private static void addElementsToList() {
		if(list==null)
			list = new ArrayList<>();
		new Thread(new TaskExecutor(list, Operation.ADD)).start();
		
	}
	
	private static void removeLast() {
		if(list==null)
			list = new ArrayList<>();
		new Thread(new TaskExecutor(list, Operation.REMOVELAST));
	}

}


class TaskExecutor implements Runnable {
	
	Operation operation;
	List listConcurrent;
	
	
	public TaskExecutor(List valueConcurrent,Operation operation) {
		this.listConcurrent = valueConcurrent;
		this.operation = operation;
	}
	
	public void run() {
		switch (operation) {
		case ADD:
			System.out.println("starting to add elements");
			synchronized (listConcurrent) {
			for (int i = 0; i < 30; i++) {
					listConcurrent.add(i);	
					System.out.println("added "+i);
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				}
			try {
				listConcurrent.wait();
				System.out.println("operation add completes");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		break;
		case REMOVELAST:
			
			synchronized (listConcurrent) {
				System.out.println("Deleting last element in list");
				for (int i = 0; i < 10; i++) {
					if (listConcurrent.size() > 0) {
						System.out.println("deleted " + i);
						listConcurrent.remove(listConcurrent.size() - 1);
						try {
							Thread.currentThread().sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				try {
					listConcurrent.wait();
					System.out.println("operation remove completes");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			break;
		}
	}
}

enum Operation{
	ADD,REMOVELAST,REMOVEALL
}