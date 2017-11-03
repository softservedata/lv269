package com.softserve.edu.lv269;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.softserve.edu.lv269.PerfectNumber;

public class TestPerfectNumber {

	@Test
	public void findPerfectNumberTest() {
		List<Integer> expected = new ArrayList<>();
		expected.add(496);
		expected.add(28);
		expected.add(6);
		PerfectNumber perfectNumber = new PerfectNumber();
		List<Integer> actual = perfectNumber.findPerfectNumber(1000);
		assertEquals(expected, actual);
	}

}
