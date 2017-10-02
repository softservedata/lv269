package home.olex.task2test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import home.olex.task2.SecondTask;

public class SecondTaskTest {

	@Test
	public void testSecondTask() {
		int n = 99;
		int m = 111;
		SecondTask st = new SecondTask(n, m);

		assertTrue(st.getN() == n);
		assertTrue(st.getM() == m);
		assertTrue(st.getMN() == m * n);
	}

	@Test
	public void testGetTaskResult() {
		SecondTask st1 = new SecondTask(3, 9);
		SecondTask st2 = new SecondTask(3, 0);
		SecondTask st3 = new SecondTask(3, 4);

		List<Integer> result1 = new ArrayList<Integer>();
		List<Integer> result2 = new ArrayList<Integer>();
		List<Integer> result3 = new ArrayList<Integer>();
		
		result1.add(9);
		result1.add(18);
		assertEquals(st1.getTaskResult(), result1);
		assertEquals(st2.getTaskResult(), result2);
		assertEquals(st3.getTaskResult(), result3);
	}
}