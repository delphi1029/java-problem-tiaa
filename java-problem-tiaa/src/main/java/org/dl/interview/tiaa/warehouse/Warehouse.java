package org.dl.interview.tiaa.warehouse;

public class Warehouse {
	
	private int numberOfBolts;
	private int numberOfMachines;
	
	public Warehouse(final int numberOfBolts, final int numberOfMachines) {
		super();
		this.numberOfBolts = numberOfBolts;
		this.numberOfMachines = numberOfMachines;
	}

	public int getNumberOfBolts() {
		return numberOfBolts;
	}

	public int getNumberOfMachines() {
		return numberOfMachines;
	}
}
