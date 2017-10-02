package home.olex.task1test;

import static org.junit.Assert.*;

import org.junit.Test;

import home.olex.task1.FirstTask;

public class FirstTaskTest {

	@Test
	public void testFirstTask() {
		int n = 99;
		int m = 111;
		FirstTask ft = new FirstTask(n, m);
		
		assertTrue(ft.getN() == n);
		assertTrue(ft.getM() == m);
	}

	@Test
	public void testGetSum() {
		FirstTask ft = new FirstTask(1, 1);
		
		assertTrue(ft.getSum(12345, 2) == 9);
		assertTrue(ft.getSum(0, 1) == 0);
		assertTrue(ft.getSum(-12345, 2) == 9);
		
		assertTrue(ft.getSum(123456, 10) == 0);
	}

	@Test
	public void testGetDigitsCount() {
		FirstTask ft = new FirstTask(1, 1);
		
		assertTrue(ft.getDigitsCount(11111) == 5);		
		assertTrue(ft.getDigitsCount(0) == 0);
		assertTrue(ft.getDigitsCount(-111) == 3);
	}
}
