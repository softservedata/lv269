package com.softserve.edu.lv269;

import java.util.ArrayList;
import java.util.List;

/**
 * Task 330.
 *
 * @author Yura Ivanytsky
 *
 * @version 1.0
 */
public class PerfectNumber {

	/**
	 * This method find a perfect numbers.
	 * 
	 * @param n
	 * @return List lst.
	 */
	public List<Integer> findPerfectNumber(int n) {
		List<Integer> lst = new ArrayList<>();
		while (n != 1) {
			int b = n - 1;
			int sum = 0;
			for (int i = 1; i < b; i++) {
				int temp = b % i;
				if (temp == 0) {
					sum += i;
				}
			}
			if (b == sum) {
				lst.add(b);
			}
			sum = 0;
			n--;
		}
		return lst;
	}

}
