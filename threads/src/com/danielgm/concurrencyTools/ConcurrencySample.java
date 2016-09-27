package com.danielgm.concurrencyTools;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConcurrencySample {
	
	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(3);
		Runnable runable[] = {new Runnable() {
			@Override
			public void run() {
				System.out.println("I'm running "+Thread.currentThread().getId());
			}
		},
				new Runnable() {
			@Override
			public void run() {
				System.out.println("I'm running "+Thread.currentThread().getId());
			}
		}
		};
		
		for (Runnable runnable : runable) {
			executor.execute(runnable);
		}
		
		}
		
		
	

}
