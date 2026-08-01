package com.multithreading.service.impl;

import com.multithreading.service.CounterService;


public class CounterServiceImpl implements CounterService {
	private int count;

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void incrementCount() {
		++count;
	}
	//Step 1: Read count
	//Step 2: Add 1
	//Step 3: Store back
	// race condition
}
