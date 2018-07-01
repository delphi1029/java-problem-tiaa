package org.dl.interview.tiaa.service;

import static org.junit.Assert.assertEquals;

import org.dl.interview.tiaa.warehouse.Warehouse;
import org.junit.Before;
import org.junit.Test;

public class TestTimeCalculatorService {
	
	private Warehouse warehouse;
	private TimeCalculatorService timeCalculatorService;
	
	@Before
	public void init() {
		timeCalculatorService = new TimeCalculatorService();
	}
	
	@Test
	public void testCalculateTimeAndNumberOfProductsForAdequateRawMaterial() {
		warehouse = new Warehouse(6,2);
		timeCalculatorService.calculateTimeandNumberOfProducts(warehouse, 3, 60);
		assertEquals(timeCalculatorService.getResult_totalProducts(), 2);
		assertEquals(timeCalculatorService.getResult_totalTime(), 60);
	}
	
	@Test
	public void testCalculateTimeAndNumberOfProductsForInAdequateRawMaterial() {
		warehouse = new Warehouse(8,1);
		timeCalculatorService.calculateTimeandNumberOfProducts(warehouse, 3, 60);
		assertEquals(timeCalculatorService.getResult_totalProducts(), 1);
		assertEquals(timeCalculatorService.getResult_totalTime(), 60);
		
	}
	
	@Test
	public void testCalculateTimeAndNumberOfProductsForNoRawMaterial() {
		warehouse = new Warehouse(4,0);
		timeCalculatorService.calculateTimeandNumberOfProducts(warehouse, 3, 60);
		assertEquals(timeCalculatorService.getResult_totalProducts(), 0);
		assertEquals(timeCalculatorService.getResult_totalTime(), 0);
		
	}

}
