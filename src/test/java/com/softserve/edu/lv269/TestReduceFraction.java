package com.softserve.edu.lv269;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.softserve.edu.lv269.ReduceFraction;

public class TestReduceFraction {

	
	@Test
	public void commonDividerTest() {
		ReduceFraction rf = new ReduceFraction();
		int expected = 2;
		int actual = rf.commonDivider(6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	public void reduced() {
		ReduceFraction rf = new ReduceFraction();
		List<Integer> expected = new ArrayList<>();
		expected.add(3);
		expected.add(1);
		List<Integer> actual = rf.reduced(12, 4);
		assertEquals(expected, actual);
	}
}
