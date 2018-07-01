package org.dl.interview.tiaa.result;

public class Result {
	
	private int numberOfProducts;
	private int totalToCreateProducts;
	
	public int getNumberOfProducts() {
		return numberOfProducts;
	}
	public void incrementNoOfProducts() {
		this.numberOfProducts++;
	}
	public int getTotalTimeToCreateProducts() {
		return totalToCreateProducts;
	}
	public void addToTotalTime(int totalTime) {
		this.totalToCreateProducts = this.totalToCreateProducts + totalTime;
	}
}
