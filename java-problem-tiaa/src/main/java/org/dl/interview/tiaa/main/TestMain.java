package org.dl.interview.tiaa.main;

import java.util.concurrent.ExecutionException;

import org.dl.interview.tiaa.service.TimeCalculatorService;
import org.dl.interview.tiaa.warehouse.Warehouse;

public class TestMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int numberOfBolts = 12;
		int numberOfMachine = 6;
		int timeTakenToCreateProduct = 60;
		int numberOfWorkers = 3;
		
		System.out.println("----- Input  ----");
		System.out.println("Number Of Bolts in Warehouse - "+numberOfBolts);
		System.out.println("Number Of Machines in Warehouse - "+numberOfMachine);
		System.out.println("Number Of Worker Threads - "+numberOfWorkers);
		System.out.println("Time taken to create product - "+timeTakenToCreateProduct);
		System.out.println("-----------------");
		System.out.println();
		
		Warehouse warehouse = new Warehouse(numberOfBolts,numberOfMachine);
		TimeCalculatorService service = new TimeCalculatorService();
		
		System.out.println("----- Output  ----");
		service.calculateTimeandNumberOfProducts(warehouse, numberOfWorkers, timeTakenToCreateProduct);
		System.out.println("------------------");
	}

}
