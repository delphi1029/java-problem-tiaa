package org.dl.interview.tiaa.worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.dl.interview.tiaa.result.Result;

public class WorkerPool {
	
	private ExecutorService service;

	public WorkerPool(int numberOfWorkers) {
		super();
		this.service = Executors.newFixedThreadPool(numberOfWorkers);
	}
	
	public List<Future<Result>> executeWork(List<Worker> workerList) {
		List<Future<Result>> results = new ArrayList<>();
		try {
			results = service.invokeAll(workerList);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		return results;
	}
	
	public void shutDown() {
		this.service.shutdown();
	}

}
