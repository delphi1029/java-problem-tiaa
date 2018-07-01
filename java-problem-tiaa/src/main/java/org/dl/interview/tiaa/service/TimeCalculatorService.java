package org.dl.interview.tiaa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.dl.interview.tiaa.conveyerbelt.ConveyerBelt;
import org.dl.interview.tiaa.result.Result;
import org.dl.interview.tiaa.warehouse.Warehouse;
import org.dl.interview.tiaa.worker.Worker;
import org.dl.interview.tiaa.worker.WorkerPool;

public class TimeCalculatorService {

	private int result_totalProducts = 0;
	private int result_totalTime = 0;
	
	public  void calculateTimeandNumberOfProducts(Warehouse warehouse, int numberOfWorkers, int timeToCreateProduct) {
		
		ConveyerBelt belt = new ConveyerBelt(warehouse.getNumberOfBolts(), warehouse.getNumberOfMachines());
		WorkerPool pool = new WorkerPool(numberOfWorkers);

		List<Worker> workerList = createWorkers(numberOfWorkers, belt, timeToCreateProduct);
		List<Future<Result>> results = pool.executeWork(workerList);
		fetchAndPrintResult(results);
		pool.shutDown();
	}

	
	private void fetchAndPrintResult(List<Future<Result>> results) {

		for(Future<Result> result : results) {
			try {
				result_totalProducts = result_totalProducts + result.get().getNumberOfProducts();
				if(result_totalTime < result.get().getTotalTimeToCreateProducts()) {
					result_totalTime = result.get().getTotalTimeToCreateProducts();
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Total Number Of Products - "+result_totalProducts);
		System.out.println("Total Time Taken - "+ result_totalTime);
		
	}

	private List<Worker> createWorkers(final int numberOfWorkers, final ConveyerBelt belt,final int timeToCreateProduct) {
		List<Worker> workerList = new ArrayList<>();
		for(int i=0; i<numberOfWorkers;i++) {
			workerList.add(new Worker(belt,timeToCreateProduct));
			workerList.add(new Worker(belt,timeToCreateProduct));
			workerList.add(new Worker(belt,timeToCreateProduct));
		}
		return workerList;
	}


	public int getResult_totalProducts() {
		return result_totalProducts;
	}


	public int getResult_totalTime() {
		return result_totalTime;
	}

}
