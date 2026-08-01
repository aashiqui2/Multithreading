package com.multithreading;

import com.multithreading.utility.MyThread;


public class Demo2 extends Thread {
	public static void main(String[] args) {
		Thread thread = new MyThread();
		// When all USER (non-daemon) threads stop, the JVM exits — and ONLY THEN daemon threads are stopped
		thread.setDaemon(true);//example garbage collector
		thread.start();
		//thread.setDaemon(true); cannot be after start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Executing " + Thread.currentThread().getName());
	}
}
