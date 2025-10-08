package com.multithreading.service.impl;

import com.multithreading.service.CounterService;


public class CounterServiceImpl3 implements CounterService {
	private int count;

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void incrementCount() {
		//synchronized block
		synchronized (this) {
			++count;
		}
	}
}
