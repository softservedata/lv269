package home.olex.task1test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import home.olex.task1.DigitsSum;

public class FirstTaskTest {
	private DigitsSum digSum;
	
	@Before
    public void initObjects() {
		digSum = new DigitsSum();
    }
	
	@Test
	public void testGetSum() {
		assertTrue(digSum.getSum(Integer.MAX_VALUE, 3) == 17);
		assertTrue(digSum.getSum(1, 1) == 1);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testExceptionGetSum1() {
		digSum.getSum(0, 1);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testExceptionGetSum2() {
		digSum.getSum(Integer.MIN_VALUE, 2);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testExceptionGetSum3() {
		digSum.getSum(123456, 10);
	}

	@Test
	public void testGetDigitsCount() {
		assertTrue(digSum.getDigitsCount(Integer.MAX_VALUE) == 10);		
		assertTrue(digSum.getDigitsCount(0) == 0);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testExceptionGetDigitsCount1() {
		digSum.getDigitsCount(-1);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testExceptionGetDigitsCount2() {
		digSum.getDigitsCount(Integer.MIN_VALUE);
	}
}