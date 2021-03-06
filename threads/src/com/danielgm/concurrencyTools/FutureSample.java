package com.danielgm.concurrencyTools;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureSample {
	
	public static void main(String[] args) {
		
		Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
	};
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor. submit(task);

		System.out.println("future done? " + future.isDone());

		Integer result = -1;
		try {
			result = future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);	
	}

	
			
	
}



