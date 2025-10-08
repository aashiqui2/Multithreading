package com.multithreading;

import com.multithreading.repository.EmployeeRepository;
import com.multithreading.repository.impl.EmployeeRepositoryImpl1;
import com.multithreading.repository.impl.EmployeeRepositoryImpl2;
import com.multithreading.repository.impl.EmployeeRepositoryImpl3;
import com.multithreadingservice.impl.EmployeeServiceImpl;

public class Demo2 {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " started fetching");
		EmployeeServiceImpl employeeServiceImpl = null;
		EmployeeRepository[] employeeRepositories = { 
			new EmployeeRepositoryImpl1(), new EmployeeRepositoryImpl2(),new EmployeeRepositoryImpl3() };

		Thread[] employeeServices = new Thread[employeeRepositories.length];

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < employeeRepositories.length; i++) {
			employeeServiceImpl = new EmployeeServiceImpl(employeeRepositories[i]);
			employeeServices[i] = new Thread(employeeServiceImpl);

			employeeServices[i].setName("Custom Thread - " + i);
			// By default the thread priority is 5 ranging from 0-10
			// *The minimum priority that is assigned to a thread. MIN_PRIORITY = 1;
			// *The default priority that is assigned to a thread. NORM_PRIORITY = 5;
			// *The maximum priority that a thread can have. MAX_PRIORITY = 10;
			//System.out.println(employeeServices[i].getPriority());


			System.out.println("Just after using new keyword -> Name: " 
			        + employeeServices[i].getName() + ", isAlive: "
					+ employeeServices[i].isAlive() + ", state: " 
			        + employeeServices[i].getState());

			employeeServices[i].start();

			System.out.println("Just after using start method -> Name: " 
			        + employeeServices[i].getName() + ", isAlive: "
					+ employeeServices[i].isAlive() + ", state: " 
			        + employeeServices[i].getState());
		}

		for (int i = 0; i < employeeServices.length; i++) {
			try {
				employeeServices[i].join();
				
				System.out.println("Just after using join method -> Name: " 
				        + employeeServices[i].getName()
						+ ", isAlive: " + employeeServices[i].isAlive() + ", state: " 
				        + employeeServices[i].getState());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
		System.out.println(Thread.currentThread().getName() + " finished fetching");
	}
}
