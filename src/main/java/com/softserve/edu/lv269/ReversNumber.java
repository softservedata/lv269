package com.softserve.edu.lv269;


/**
 * Task 88 b.
 *
 * @author Yura Ivanytsky
 *
 * @version 1.0
 *
 */
public class ReversNumber {

	/**
	 * This method reverses the number.
	 * 
	 * @param n
	 * @return int result.
	 */
	public int invertedNumber(int n) {
		int result = 0;
		while (n > 0) {
			result = result * 10 + n % 10;
			n /= 10;
		}
		return result;
	}

}
