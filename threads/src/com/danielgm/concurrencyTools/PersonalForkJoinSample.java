package com.danielgm.concurrencyTools;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class PersonalForkJoinSample {
	public static void main(String[] args) {
		int src[] = new int[100];
		int dest[] = new int[100];
		
		for (int i = 0; i < 100; i++) {
			src[i] = i;
		}
		
		ForkJoinAction forkJoinAction = new ForkJoinAction(src, dest, 0,src.length);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		
		ForkJoinTask<Void> submit = forkJoinPool.submit(forkJoinAction);
		
		try {
			submit.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < dest.length; i++) {
			System.out.println(src[i]+"|"+dest[i]);
		}
		
	}
}

class ForkJoinAction extends RecursiveAction{

	int src[];
	int dest[];
	int start;
	int length;
	int threshold = 10;
	
	
	public ForkJoinAction(int[] src, int[] dest, int start,int length) {
	
		super();
		this.src = src;
		this.dest = dest;
		this.start = start;
		this.length = length;
	}

	@Override
	protected void compute() {
		if(length-start<=threshold){
			computeDirectly();
		}else{
			invokeAll(new ForkJoinAction[]{
					new ForkJoinAction(src,dest,start,start+threshold),
					new ForkJoinAction(src,dest,(start+threshold),src.length),
			});
		}
	}
	
	private void computeDirectly(){
		for(int i=start;i<start+threshold;i++){
			dest[i] = src[i]*2;
		}
	}
	
}
