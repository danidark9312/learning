package com.danielgm.thread.queueLockExample;

public interface ThreadStorage {
	
	void addMessage(String message);
	void readQueue();

}
