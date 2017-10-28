package home.olex.task3test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import home.olex.task1.DigitsSum;
import home.olex.task3.MersennePrime;

public class ThirdTaskTest {

	private MersennePrime mp;
	
	@Before
    public void initObjects() {
		mp = new MersennePrime();
    }	
	
	@Test
	public void testGetMersennNumbers() {
		MersennePrime mp1 = new MersennePrime();
		MersennePrime mp2 = new MersennePrime();

		//res is: 3, 7, 31, 127, 8191, 131071, 524287
		
		List<Integer> result1 = new ArrayList<Integer>();
		List<Integer> result2 = new ArrayList<Integer>();
		
		result1.add(3);
		result1.add(7);
		result1.add(31);
		result1.add(127);
		result1.add(8191);
		
		assertEquals(mp1.getMersennNumbers(9999), result1);
		assertEquals(mp2.getMersennNumbers(0), result2);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testExceptionGetMersennNumbers() {
		mp.getMersennNumbers(-9999);
	}

	@Test
	public void testGetCandidate() {
		assertTrue(mp.getCandidate(3) == 7);
		assertTrue(mp.getCandidate(0) == 0);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testExceptionGetCandidate() {
		mp.getCandidate(-1);
	}

	@Test
	public void testGetPow() {
		assertTrue(mp.getPow(2, 10) == 1024);
		assertTrue(mp.getPow(3, 0) == 1);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testExceptionGetPow1() {
		mp.getPow(-10, 2);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testExceptionGetPow2() {
		mp.getPow(-10, -2);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testExceptionGetPow3() {
		mp.getPow(10, -2);
	}

	@Test
	public void testIsPrime() {
		assertTrue("Should be NOT prime", !mp.isPrime(0));
		assertTrue("Should be NOT prime", !mp.isPrime(-1));
		assertTrue("Should be NOT prime", !mp.isPrime(1));
		assertTrue("Should be prime", mp.isPrime(2));
		assertTrue("Should be NOT prime", !mp.isPrime(100));
		assertTrue("Should be prime", mp.isPrime(101));
	}
}