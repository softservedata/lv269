package com.softserve.edu.lv269;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.softserve.edu.lv269.ReversNumber;

public class TestReversNumber {

	
	@Test
	public void invertedNumberTest() {
		ReversNumber rn = new ReversNumber();
		int expected = 321;
		int actual = rn.invertedNumber(123);
		assertEquals(expected, actual);
	}
}
