package com.softserve.edu.exercise2;

/**
 * NCD calculate.
 * 
 * @author Andron
 *
 */
public class NCD {

    /**
	 * NCD.
	 * @param a
	 *            first Number
	 * @param b
	 *            Number-1
	 * @return NCD
	 */
	public int progNCD(final int a, final int b) {
		if (b != 0) {
			return progNCD(b, a % b);
		} else {
			return a;
		}
	}
}
