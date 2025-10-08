package com.multithreading.service.impl;

import com.multithreading.service.CounterService;


public class CounterServiceImpl2 implements CounterService {
	private int count;

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public synchronized void incrementCount() {
		++count;
		// fetch the current value
		// add + 1 with current value
		// assign incremented value to current value
	}
}
