package org.dl.interview.tiaa.conveyerbelt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.dl.interview.tiaa.rawmaterial.RawMaterial;
import org.dl.interview.tiaa.rawmaterial.RawMaterialType;
import org.junit.Before;
import org.junit.Test;

public class TestConveyerBelt {
	
	private ConveyerBelt belt;
	
	@Before
	public void init() {
		 belt = new ConveyerBelt(2,1); 
	}
	
	@Test
	public void testAccess() {
		RawMaterial rawMaterial = null;
		rawMaterial = belt.access();
		assertEquals(RawMaterialType.BOLT, rawMaterial.getType());
		rawMaterial = belt.access();
		assertEquals(RawMaterialType.BOLT, rawMaterial.getType());
		rawMaterial = belt.access();
		assertEquals(RawMaterialType.MACHINE, rawMaterial.getType());
		
		assertTrue(belt.isEmpty());
	}

}
