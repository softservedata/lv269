package com.softserve.edu.exercise3;

/**
 * Class for findinf sumDIV of Number.
 * @author Andrii Kravtsov
 *
 */
public class sumDIV {
    /**
     * Method of finding sum div number.
     * @param n Number.
     * @return Sum Summary.
     */
     int findDivSum(final int n) {
		int Sum = 0;
		for (int i = 1; i <= (n / 2); i++) {
			if (n % i == 0) {
				Sum += i;
			}
		}

		return Sum;
	}

}
