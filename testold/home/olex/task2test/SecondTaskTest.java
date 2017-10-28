package home.olex.task2test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import home.olex.task2.Multiple;

public class SecondTaskTest {

	@Test
	public void testGetMultipleItems() {
		Multiple mult1 = new Multiple();
		Multiple mult2 = new Multiple();
		Multiple mult3 = new Multiple();

		List<Integer> result1 = new ArrayList<Integer>();
		List<Integer> result2 = new ArrayList<Integer>();
		List<Integer> result3 = new ArrayList<Integer>();
		
		result1.add(9);
		result1.add(18);
		assertEquals(mult1.getMultipleItems(3, 9), result1);
		assertEquals(mult2.getMultipleItems(3, 0), result2);
		assertEquals(mult3.getMultipleItems(3, 4), result3);		
	}
	
	@Test(expected = ArithmeticException.class)
	public void exceptionTestGetMultipleItems() { 
		Multiple mult = new Multiple();
		
		mult.getMultipleItems(20000, 200000);
	}
	
	@Test
	public void testIsMulSafe() {
		Multiple mult = new Multiple();
		
		//EP technique
		assertTrue(mult.isMulSafe(3, 3) == true);
		assertTrue(mult.isMulSafe(Integer.MAX_VALUE, 2) == false);
		assertTrue(mult.isMulSafe(Integer.MIN_VALUE, 2) == false);			
	}
}