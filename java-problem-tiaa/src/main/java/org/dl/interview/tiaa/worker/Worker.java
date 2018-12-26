package org.dl.interview.tiaa.worker;

import java.util.concurrent.Callable;

import org.dl.interview.tiaa.conveyerbelt.ConveyerBelt;
import org.dl.interview.tiaa.rawmaterial.RawMaterial;
import org.dl.interview.tiaa.rawmaterial.RawMaterialType;
import org.dl.interview.tiaa.result.Result;

public class Worker implements Callable<Result> {

	private ConveyerBelt belt;
	private Integer boltsRequired;
	private Integer machineRequired;
	private int timeToCreateProduct;

	public Worker(final ConveyerBelt belt, final int timeToCreateProduct) {
		super();
		this.belt = belt;
		this.timeToCreateProduct = timeToCreateProduct;
		this.boltsRequired = new Integer(2);
		this.machineRequired = new Integer(1);
	}

	public Result call() {
		Result result = new Result();
		while (!belt.isEmpty()) {
			belt.lock();
			pickRawMaterial();
			belt.unlock();
			assembleProduct(result);
		}
		return result;
	}

	protected void pickRawMaterial() {
		while ((boltsRequired != 0 || machineRequired != 0) && !belt.isEmpty()) {
			RawMaterial rawMaterial = belt.access();
			if (rawMaterial.getType() == RawMaterialType.BOLT) {
				if (boltsRequired > 0) {
					boltsRequired--;
				}
			} else {
				if (machineRequired > 0) {
					machineRequired--;
				}
			}
		}
	}

	protected void assembleProduct(Result result) {
		if (boltsRequired == 0 && machineRequired == 0) {
			try {
				Thread.sleep(timeToCreateProduct);
				reset();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			result.incrementNoOfProducts();
			result.addToTotalTime(timeToCreateProduct);
		}
	}

	private void reset() {
		boltsRequired = 2;
		machineRequired = 1;
	}

}
