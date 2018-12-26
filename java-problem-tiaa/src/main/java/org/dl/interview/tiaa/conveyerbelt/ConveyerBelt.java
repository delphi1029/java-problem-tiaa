package org.dl.interview.tiaa.conveyerbelt;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import org.dl.interview.tiaa.rawmaterial.Bolt;
import org.dl.interview.tiaa.rawmaterial.Machine;
import org.dl.interview.tiaa.rawmaterial.RawMaterial;

public class ConveyerBelt extends ReentrantLock {
	
	private static final long serialVersionUID = 1L;
	private final BlockingQueue<RawMaterial> queue;
	private final int numberOfBolts;
	private final int numberOfMachines;
	
	
	public ConveyerBelt(final int numberOfBolts, final int numberOfMachines) {
		super();
		this.numberOfBolts = numberOfBolts;
		this.numberOfMachines = numberOfMachines;
		this.queue = new LinkedBlockingQueue<>();
		loadBelt();
	}

	//As mentioned in the problem statement sequence will always be 2 bolts and 1 machine
	private void loadBelt() {
		for(int i=numberOfBolts,j=numberOfMachines; i>0 || j>0;) {
			queue.offer(new Bolt());
			i--;
			if(i>0) {
				queue.offer(new Bolt());
				i--;
			}
			if(j>0) {
				queue.offer(new Machine());
				j--;
			}
		}
		
	}
	
	public RawMaterial access() {
		RawMaterial rawMaterial = null;
		try {
			rawMaterial =  queue.take();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		return rawMaterial;
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public int getRawMaterialCount() {
		return queue.size();
	}

}
