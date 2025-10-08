package com.multithreading;

import com.multithreading.repository.impl.EmployeeRepositoryImpl1;
import com.multithreading.repository.impl.EmployeeRepositoryImpl2;
import com.multithreading.repository.impl.EmployeeRepositoryImpl3;
import com.multithreading.service.impl.EmployeeServiceImpl;


public class Demo {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " started fetching");
		EmployeeServiceImpl employeeServiceImpl = null;
		
		long startTime = System.currentTimeMillis();
		employeeServiceImpl = new EmployeeServiceImpl(new EmployeeRepositoryImpl1());
		employeeServiceImpl.run();
		employeeServiceImpl = new EmployeeServiceImpl(new EmployeeRepositoryImpl2());
		employeeServiceImpl.run();
		employeeServiceImpl = new EmployeeServiceImpl(new EmployeeRepositoryImpl3());
		employeeServiceImpl.run();
		
		System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
		System.out.println(Thread.currentThread().getName() + " finished fetching");
	}
}
