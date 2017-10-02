package home.olex.task3test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import home.olex.task3.ThirdTask;

public class ThirdTaskTest {

	@Test
	public void testThirdTask() {
		int n = 9;
		ThirdTask tt = new ThirdTask(n);

		assertTrue(tt.getN() == n);
	}

	@Test
	public void testGetTaskResult() {
		ThirdTask tt1 = new ThirdTask(9999);
		ThirdTask tt2 = new ThirdTask(0);
		ThirdTask tt3 = new ThirdTask(-9999);

		//3, 7, 31, 127, 8191, 131071, 524287
		
		List<Integer> result1 = new ArrayList<Integer>();
		List<Integer> result2 = new ArrayList<Integer>();
		List<Integer> result3 = new ArrayList<Integer>();
		
		result1.add(3);
		result1.add(7);
		result1.add(31);
		result1.add(127);
		result1.add(8191);
		
		assertEquals(tt1.getTaskResult(), result1);
		assertEquals(tt2.getTaskResult(), result2);
		assertEquals(tt3.getTaskResult(), result3);
	}

	@Test
	public void testGetCandidate() {
		ThirdTask tt = new ThirdTask(1);

		assertTrue(tt.getCandidate(3) == 7);
	}

	@Test
	public void testGetPow() {
		ThirdTask tt = new ThirdTask(1);

		assertTrue(tt.getPow(2, 10) == 1024);
		assertTrue(tt.getPow(-10, 2) == 100);
		assertTrue(tt.getPow(3, 0) == 1);
	}

	@Test
	public void testIsPrime() {
		ThirdTask tt = new ThirdTask(1);

		assertTrue("Should be prime", tt.IsPrime(7));
		assertTrue("Should be NOT prime", !tt.IsPrime(8));
		assertTrue("Should be NOT prime", !tt.IsPrime(0));
		assertTrue("Should be NOT prime", !tt.IsPrime(-10));
	}

}