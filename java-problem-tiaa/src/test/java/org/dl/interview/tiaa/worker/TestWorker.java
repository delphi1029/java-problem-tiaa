package org.dl.interview.tiaa.worker;

import static org.junit.Assert.assertEquals;

import org.dl.interview.tiaa.conveyerbelt.ConveyerBelt;
import org.junit.Before;
import org.junit.Test;

public class TestWorker {
	
	private ConveyerBelt belt;
	private Worker worker;
	
	@Before
	public void init() {
		 belt = new ConveyerBelt(6,3); 
		 worker = new Worker(belt, 60);
	}
	
	@Test
	public void testPickRawMaterial() {
		assertEquals(belt.getRawMaterialCount(), 9);
		worker.pickRawMaterial();
		assertEquals(belt.getRawMaterialCount(), 6);
	}

}
