package com.danielgm.thread.queueLockExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainInput {
	
	/**
	 * @param sysargs
	 * @throws IOException
	 */
	public static void main(String[] sysargs) throws IOException {
		System.out.println("Options in menu are: \n 1.add Element to list");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		ThreadStorage threadStorage= null;
		
		while((line = br.readLine())!=null){
			String[] args = line.split("\\s+"); //whitespaces one or more
			if(args[0].equals("1")){
				if(threadStorage == null)
					threadStorage = new QueueWatcher(2,5_000);
				threadStorage.addMessage(args[1]);
			}
			
		}
	}
}
