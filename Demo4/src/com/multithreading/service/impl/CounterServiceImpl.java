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
}
